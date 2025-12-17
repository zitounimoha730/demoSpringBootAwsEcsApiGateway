package com.example.demobooksspringbootapi.application.rest.book.controller;

import com.example.demobooksspringbootapi.application.adapter.book.BookAdapter;
import com.example.demobooksspringbootapi.application.rest.book.dto.BookDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import jakarta.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {
    private final BookAdapter adapter;

    @PostMapping
    public Mono<ResponseEntity<BookDto>> createBook(@Valid @RequestBody BookDto bookDto) {
        return adapter.createBook(bookDto).map(status(HttpStatus.CREATED)::body);
    }

    @GetMapping
    public Mono<ResponseEntity<List<BookDto>>> readAllBooks(BookDto criteria) {
        return adapter.readAllBooks(criteria).map(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<BookDto>> updateBook(@Valid @RequestBody BookDto dto, @PathVariable("id") Long id) {
        return adapter.updateBook(dto.withId(id)).map(ResponseEntity::ok);
    }
}
