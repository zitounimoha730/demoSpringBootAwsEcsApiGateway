package com.example.demobooksspringbootapi.infrastructure.commons.mappers;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import com.example.demobooksspringbootapi.infrastructure.commons.entities.BookEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface BookEntityMapper extends DefaultEntityMapper<Book, BookEntity> {
}
