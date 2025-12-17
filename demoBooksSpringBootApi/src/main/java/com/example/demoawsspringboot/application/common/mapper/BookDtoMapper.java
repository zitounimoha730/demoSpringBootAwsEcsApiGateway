package com.example.demoawsspringboot.application.common.mapper;

import com.example.demoawsspringboot.application.rest.book.dto.BookDto;
import com.example.demoawsspringboot.domain.book.entity.Book;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface BookDtoMapper extends DefaultDtoMapper<Book, BookDto> {
}
