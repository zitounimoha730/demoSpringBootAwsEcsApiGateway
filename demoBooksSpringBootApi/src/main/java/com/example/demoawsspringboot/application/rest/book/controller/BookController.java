package com.example.demoawsspringboot.application.rest.book.controller;

import com.example.demoawsspringboot.application.adapter.book.BookAdapter;
import com.example.demoawsspringboot.application.rest.book.dto.BookDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {
    private final BookAdapter adapter;

    @PostMapping
    public Mono<ResponseEntity<BookDto>> createBook(@RequestBody BookDto bookDto) {
        return adapter.createBook(bookDto).map(status(HttpStatus.CREATED)::body);
    }

    @GetMapping
    public Mono<ResponseEntity<List<BookDto>>> readAllBooks() {
        return adapter.readAllBooks().map(ResponseEntity::ok);
    }
}
