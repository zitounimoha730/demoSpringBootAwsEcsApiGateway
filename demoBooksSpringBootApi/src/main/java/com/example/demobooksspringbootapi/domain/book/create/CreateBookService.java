package com.example.demobooksspringbootapi.domain.book.create;

import com.example.demobooksspringbootapi.domain.book.commons.constants.BookConstants;
import com.example.demobooksspringbootapi.domain.book.create.entity.CreateBookCommand;
import com.example.demobooksspringbootapi.domain.book.create.entity.CreateBookHelperModel;
import com.example.demobooksspringbootapi.domain.book.create.entity.CreateBookResponse;
import com.example.demobooksspringbootapi.domain.book.create.ports.CreateBookRepository;
import com.example.demobooksspringbootapi.domain.book.create.ports.CreateBookUseCase;
import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import com.example.demobooksspringbootapi.domain.commons.errors.DomainException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class CreateBookService implements CreateBookUseCase {
    private final CreateBookRepository repository;
    @Override
    public Mono<CreateBookResponse> process(CreateBookCommand command) {
        return validate(command.get())
                .map(this::buildCreatedBook)
                .flatMap(this::saveBook)
                .doOnError(th -> log.atError().log("Error creating book!", th))
                .map(CreateBookResponse::defaultResponse)
                .onErrorResume(th -> Mono.just(CreateBookResponse.errorResponse(th.getMessage())));
    }

    private Book buildCreatedBook(Book book) {
        return new CreateBookHelper(new CreateBookHelperModel(book)).createdBook();
    }

    private Mono<Book> saveBook(Book book) {
        return repository.create(book)
                .doOnError(th -> log.atWarn().log("Error while saving new book in database!", th));
    }

    private Mono<Book> validate(Book book) {
        if(book.title().toUpperCase().startsWith(BookConstants.EXPENSIVE_BOOKS_PREFIX) && book.price() < BookConstants.EXPENSIVE_BOOKS_PRICE) {
            return Mono.error( new DomainException(BookConstants.INVALID_BOOK_PRICE_ERROR_MESSAGE));
        }
        return Mono.just(book);
    }
}
