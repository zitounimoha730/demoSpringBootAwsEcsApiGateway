package com.example.demoawsspringboot.infrastructure.common.mappers;

import com.example.demoawsspringboot.domain.book.entity.Book;
import com.example.demoawsspringboot.infrastructure.common.entities.BookEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface BookEntityMapper extends DefaultEntityMapper<Book, BookEntity> {
}
