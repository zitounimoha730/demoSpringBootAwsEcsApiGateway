package com.example.demoarchitecturehexagonal.domain.book.update.entity;

import com.example.demoarchitecturehexagonal.domain.book.commons.entity.Book;

public record UpdateBookHelperModel(Book newBook, Book existingBook) {
}
