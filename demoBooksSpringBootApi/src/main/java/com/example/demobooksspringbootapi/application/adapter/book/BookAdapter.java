package com.example.demobooksspringbootapi.application.adapter.book;

import com.example.demobooksspringbootapi.application.rest.book.dto.BookDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BookAdapter {
    Mono<BookDto> createBook(BookDto bookDto);
    Mono<List<BookDto>> readAllBooks(BookDto bookDto);
    Mono<BookDto> updateBook(BookDto bookDto);
}
