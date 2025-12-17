package com.example.demobooksspringbootapi.domain.book.create;

import com.example.demobooksspringbootapi.domain.book.create.entity.CreateBookHelperModel;
import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class CreateBookHelper {
    private final CreateBookHelperModel model;

    public Book createdBook() {
        return model.newBook()
                .withActive(true)
                .withHorodateCreation(LocalDateTime.now())
                .withHorodateMaj(null);
    }
}
