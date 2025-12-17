package com.example.demobooksspringbootapi.domain.book.update;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import com.example.demobooksspringbootapi.domain.book.update.entity.UpdateBookHelperModel;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class UpdateBookHelper {
    private final UpdateBookHelperModel model;

    public Book updatedBook() {
        return model.newBook()
                .withHorodateCreation(model.existingBook().horodateCreation())
                .withHorodateMaj(LocalDateTime.now());
    }
}
