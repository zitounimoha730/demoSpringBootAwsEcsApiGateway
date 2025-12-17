package com.example.demobooksspringbootapi.domain.book.readall.ports;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import reactor.core.publisher.Mono;

import java.util.List;

@SecondaryPort
public interface ReadAllBooksRepository {
    Mono<List<Book>> fetchAll();
}
