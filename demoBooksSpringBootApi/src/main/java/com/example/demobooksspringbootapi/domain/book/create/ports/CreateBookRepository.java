package com.example.demobooksspringbootapi.domain.book.create.ports;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import reactor.core.publisher.Mono;

@SecondaryPort
public interface CreateBookRepository {
    Mono<Book> create(Book book);
}
