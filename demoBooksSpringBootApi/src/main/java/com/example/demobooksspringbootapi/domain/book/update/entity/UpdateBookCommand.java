package com.example.demobooksspringbootapi.domain.book.update.entity;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import com.example.demobooksspringbootapi.domain.commons.entities.DefaultDomainCommand;

public record UpdateBookCommand(Book book) implements DefaultDomainCommand<Book> {
    @Override
    public Book get() {
        return book;
    }
}
