package com.example.demobooksspringbootapi.domain.book.create.entity;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import com.example.demobooksspringbootapi.domain.commons.entities.DefaultDomainCommand;

public record CreateBookCommand(Book book) implements DefaultDomainCommand<Book> {
    @Override
    public Book get() {
        return book;
    }
}
