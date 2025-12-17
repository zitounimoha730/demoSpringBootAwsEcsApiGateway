package com.example.demoawsspringboot.domain.book.create.ports;

import com.example.demoawsspringboot.domain.book.entity.Book;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import reactor.core.publisher.Mono;

@SecondaryPort
public interface CreateBookRepository {
    Mono<Book> save(Book book);
}
