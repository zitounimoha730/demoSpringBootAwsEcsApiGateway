package com.example.demoawsspringboot.domain.book.create.entity;

import com.example.demoawsspringboot.domain.book.entity.Book;
import com.example.demoawsspringboot.domain.common.entities.DefaultDomainCommand;

public record CreateBookCommand(Book book) implements DefaultDomainCommand<Book> {
    @Override
    public Book get() {
        return book;
    }
}
