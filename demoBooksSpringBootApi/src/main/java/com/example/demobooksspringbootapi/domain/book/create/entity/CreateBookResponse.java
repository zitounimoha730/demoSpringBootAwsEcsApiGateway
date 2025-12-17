package com.example.demoawsspringboot.domain.book.create.entity;

import com.example.demoawsspringboot.domain.book.entity.Book;
import com.example.demoawsspringboot.domain.common.entities.DefaultDomainResponse;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record CreateBookResponse(Book entity, String error) implements DefaultDomainResponse<Book> {

    public static CreateBookResponse defaultResponse(Book entity) {
        return CreateBookResponse.builder().entity(entity).build();
    }

    public static CreateBookResponse errorResponse(String error) {
        return CreateBookResponse.builder().error(error).build();
    }
}
