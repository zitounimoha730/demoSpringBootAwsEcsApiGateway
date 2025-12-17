package com.example.demobooksspringbootapi.application.adapter.book;

import com.example.demobooksspringbootapi.application.commons.mappers.BookDtoMapper;
import com.example.demobooksspringbootapi.application.errors.exception.FunctionnalErrorException;
import com.example.demobooksspringbootapi.application.rest.book.dto.BookDto;
import com.example.demobooksspringbootapi.domain.book.create.entity.CreateBookCommand;
import com.example.demobooksspringbootapi.domain.book.create.entity.CreateBookResponse;
import com.example.demobooksspringbootapi.domain.book.create.ports.CreateBookUseCase;
import com.example.demobooksspringbootapi.domain.book.readall.entity.ReadAllBooksCommand;
import com.example.demobooksspringbootapi.domain.book.readall.entity.ReadAllBooksResponse;
import com.example.demobooksspringbootapi.domain.book.readall.ports.ReadAllBooksUseCase;
import com.example.demobooksspringbootapi.domain.book.update.entity.UpdateBookCommand;
import com.example.demobooksspringbootapi.domain.book.update.entity.UpdateBookResponse;
import com.example.demobooksspringbootapi.domain.book.update.ports.UpdateBookUseCase;
import lombok.AllArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@PrimaryAdapter
@AllArgsConstructor
public class BookWebAdapter implements BookAdapter {
    private final CreateBookUseCase createBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final ReadAllBooksUseCase readAllBooksUseCase;
    private final BookDtoMapper mapper = Mappers.getMapper(BookDtoMapper.class);

    @Override
    public Mono<BookDto> createBook(BookDto bookDto) {
        return createBookUseCase.process(new CreateBookCommand(mapper.toDomainEntity(bookDto)))
                .flatMap(this::buildCreateBookResponse);
    }

    @Override
    public Mono<List<BookDto>> readAllBooks(BookDto bookDto) {
        return readAllBooksUseCase.process(new ReadAllBooksCommand(mapper.toDomainEntity(bookDto)))
                .flatMap(this::buildReadAllResponse);
    }

    @Override
    public Mono<BookDto> updateBook(BookDto bookDto) {
        return updateBookUseCase.process(new UpdateBookCommand(mapper.toDomainEntity(bookDto)))
                .flatMap(this::buildUpdateBookResponse);
    }

    private Mono<BookDto> buildCreateBookResponse(CreateBookResponse response) {
        if (response.isValid()) {
            return Mono.just(mapper.toDto(response.entity()));
        }
        return Mono.error(new FunctionnalErrorException(response.error()));
    }

    private Mono<BookDto> buildUpdateBookResponse(UpdateBookResponse response) {
        if (response.isValid()) {
            return Mono.just(mapper.toDto(response.entity()));
        }
        return Mono.error(new FunctionnalErrorException(response.error()));
    }

    private Mono<List<BookDto>> buildReadAllResponse(ReadAllBooksResponse response) {
        if (response.isValid()) {
            return Mono.just(mapper.toDtoList(response.entity()));
        }
        return Mono.error(new FunctionnalErrorException(response.error()));
    }
}
