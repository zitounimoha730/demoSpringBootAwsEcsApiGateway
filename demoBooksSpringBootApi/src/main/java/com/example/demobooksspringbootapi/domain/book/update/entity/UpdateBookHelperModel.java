package com.example.demobooksspringbootapi.domain.book.update.entity;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;

public record UpdateBookHelperModel(Book newBook, Book existingBook) {
}
