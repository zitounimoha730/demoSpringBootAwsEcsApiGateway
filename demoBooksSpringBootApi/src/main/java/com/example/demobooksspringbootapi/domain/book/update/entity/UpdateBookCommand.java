package com.example.demoarchitecturehexagonal.domain.book.update.entity;

import com.example.demoarchitecturehexagonal.domain.book.commons.entity.Book;
import com.example.demoarchitecturehexagonal.domain.commons.entities.DefaultDomainCommand;

public record UpdateBookCommand(Book book) implements DefaultDomainCommand<Book> {
    @Override
    public Book get() {
        return book;
    }
}
