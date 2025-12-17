package com.example.demobooksspringbootapi.domain.book.update.entity;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import com.example.demobooksspringbootapi.domain.commons.entities.DefaultDomainResponse;
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
