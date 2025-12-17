package com.example.demoawsspringboot.domain.book.readall.entity;

import com.example.demoawsspringboot.domain.book.entity.Book;
import com.example.demoawsspringboot.domain.common.entities.DefaultDomainResponse;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record ReadAllBooksResponse(List<Book> entity, String error) implements DefaultDomainResponse<List<Book>> {

    public static ReadAllBooksResponse defaultResponse(List<Book> entity) {
        return ReadAllBooksResponse.builder().entity(entity).build();
    }

    public static ReadAllBooksResponse errorResponse(String error) {
        return ReadAllBooksResponse.builder().error(error).build();
    }
}
