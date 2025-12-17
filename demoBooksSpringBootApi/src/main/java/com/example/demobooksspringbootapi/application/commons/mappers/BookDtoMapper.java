package com.example.demobooksspringbootapi.application.commons.mappers;

import com.example.demobooksspringbootapi.application.rest.book.dto.BookDto;
import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface BookDtoMapper extends DefaultDtoMapper<Book, BookDto> {
}
