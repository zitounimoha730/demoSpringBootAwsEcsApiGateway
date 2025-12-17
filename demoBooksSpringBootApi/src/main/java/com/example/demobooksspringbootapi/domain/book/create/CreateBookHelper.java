package com.example.demoarchitecturehexagonal.domain.book.create;

import com.example.demoarchitecturehexagonal.domain.book.commons.entity.Book;
import com.example.demoarchitecturehexagonal.domain.book.create.entity.CreateBookHelperModel;
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
