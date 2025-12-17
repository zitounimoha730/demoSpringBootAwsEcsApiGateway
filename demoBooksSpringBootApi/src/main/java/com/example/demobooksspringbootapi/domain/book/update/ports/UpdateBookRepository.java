package com.example.demobooksspringbootapi.domain.book.update.ports;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import reactor.core.publisher.Mono;

@SecondaryPort
public interface UpdateBookRepository {
    Mono<Book> findById(Long id);
    Mono<Book> save(Book book);
}
