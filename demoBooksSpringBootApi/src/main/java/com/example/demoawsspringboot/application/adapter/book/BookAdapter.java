package com.example.demoawsspringboot.application.adapter.book;

import com.example.demoawsspringboot.application.rest.book.dto.BookDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BookAdapter {
    Mono<BookDto> createBook(BookDto bookDto);
    Mono<List<BookDto>> readAllBooks();
}
