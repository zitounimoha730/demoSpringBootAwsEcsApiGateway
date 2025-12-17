package com.example.demoawsspringboot.domain.book.create;

import com.example.demoawsspringboot.domain.book.create.entity.CreateBookCommand;
import com.example.demoawsspringboot.domain.book.create.entity.CreateBookResponse;
import com.example.demoawsspringboot.domain.book.create.ports.CreateBookRepository;
import com.example.demoawsspringboot.domain.book.create.ports.CreateBookUseCase;
import com.example.demoawsspringboot.domain.book.entity.Book;
import com.example.demoawsspringboot.domain.common.errors.DomainException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class CreateBookService implements CreateBookUseCase {
    private final CreateBookRepository repository;
    private static final String EXPENSIVE_BOOKS = "EXPENSIVE";
    @Override
    public Mono<CreateBookResponse> process(CreateBookCommand command) {
        return validate(command.get())
                .flatMap(this::saveBook)
                .doOnError(th -> log.atError().log("Error creating book!", th))
                .map(CreateBookResponse::defaultResponse)
                .onErrorResume(th -> Mono.just(CreateBookResponse.errorResponse(th.getMessage())));
    }

    private Mono<Book> saveBook(Book book) {
        return repository.save(book)
                .doOnError(th -> log.atWarn().log("Error while saving book in database!", th));
    }

    private Mono<Book> validate(Book book) {
        if(book.title().toUpperCase().startsWith(EXPENSIVE_BOOKS) && book.price() < 1000) {
            return Mono.error( new DomainException("The book price is invalid!"));
        }
        return Mono.just(book);
    }
}
