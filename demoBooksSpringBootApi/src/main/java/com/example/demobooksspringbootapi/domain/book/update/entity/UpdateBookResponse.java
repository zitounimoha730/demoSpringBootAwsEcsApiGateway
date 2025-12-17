package com.example.demoarchitecturehexagonal.domain.book.update.entity;

import com.example.demoarchitecturehexagonal.domain.book.commons.entity.Book;
import com.example.demoarchitecturehexagonal.domain.commons.entities.DefaultDomainResponse;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record UpdateBookResponse(Book entity, String error) implements DefaultDomainResponse<Book> {

    public static UpdateBookResponse defaultResponse(Book entity) {
        return UpdateBookResponse.builder().entity(entity).build();
    }

    public static UpdateBookResponse errorResponse(String error) {
        return UpdateBookResponse.builder().error(error).build();
    }
}
