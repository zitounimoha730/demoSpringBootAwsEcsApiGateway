package com.example.demobooksspringbootapi.infrastructure.common.mappers;

import com.example.demobooksspringbootapi.domain.book.entity.Book;
import com.example.demobooksspringbootapi.infrastructure.common.entities.BookEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface BookEntityMapper extends DefaultEntityMapper<Book, BookEntity> {
}
