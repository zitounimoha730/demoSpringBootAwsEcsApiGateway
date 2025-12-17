package com.example.demoarchitecturehexagonal.domain.book.update.ports;

import com.example.demoarchitecturehexagonal.domain.book.commons.entity.Book;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import reactor.core.publisher.Mono;

@SecondaryPort
public interface UpdateBookRepository {
    Mono<Book> findById(String id);
    Mono<Book> save(Book book);
}
