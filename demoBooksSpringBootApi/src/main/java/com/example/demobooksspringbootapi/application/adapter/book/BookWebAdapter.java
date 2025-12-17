package com.example.demoawsspringboot.application.adapter.book;

import com.example.demoawsspringboot.application.common.mapper.BookDtoMapper;
import com.example.demoawsspringboot.application.error.exception.FunctionnalErrorException;
import com.example.demoawsspringboot.application.rest.book.dto.BookDto;
import com.example.demoawsspringboot.domain.book.create.entity.CreateBookCommand;
import com.example.demoawsspringboot.domain.book.create.entity.CreateBookResponse;
import com.example.demoawsspringboot.domain.book.create.ports.CreateBookUseCase;
import com.example.demoawsspringboot.domain.book.readall.entity.ReadAllBooksCommand;
import com.example.demoawsspringboot.domain.book.readall.entity.ReadAllBooksResponse;
import com.example.demoawsspringboot.domain.book.readall.ports.ReadAllBooksUseCase;
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
    private final ReadAllBooksUseCase readAllBooksUseCase;
    private final BookDtoMapper mapper = Mappers.getMapper(BookDtoMapper.class);

    @Override
    public Mono<BookDto> createBook(BookDto bookDto) {
        return createBookUseCase.process(new CreateBookCommand(mapper.toDomainEntity(bookDto)))
                .map(this::buildCreateBookResponse);
    }

    @Override
    public Mono<List<BookDto>> readAllBooks() {
        return readAllBooksUseCase.process(new ReadAllBooksCommand())
                .map(this::buildReadAllResponse);
    }

    private BookDto buildCreateBookResponse(CreateBookResponse response) {
        if (response.isValid()) {
            return mapper.toDto(response.entity());
        }
        throw new FunctionnalErrorException(response.error());
    }

    private List<BookDto> buildReadAllResponse(ReadAllBooksResponse response) {
        if (response.isValid()) {
            return mapper.toDtoList(response.entity());
        }
        throw new FunctionnalErrorException(response.error());
    }
}
