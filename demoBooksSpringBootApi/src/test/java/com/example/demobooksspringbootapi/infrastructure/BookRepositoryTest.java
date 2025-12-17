package com.example.demobooksspringbootapi.infrastructure;

import com.example.demobooksspringbootapi.infrastructure.commons.entities.BookEntity;
import com.example.demobooksspringbootapi.infrastructure.commons.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldSaveAndFindBook() {
        BookEntity book = new BookEntity(null, "Clean Code", 29.99, true, LocalDateTime.now(), LocalDateTime.now());

        BookEntity saved = bookRepository.save(book);

        assertThat(saved.getId()).isNotNull();

        BookEntity found = bookRepository.findById(saved.getId()).orElseThrow();

        assertThat(found.getTitle()).isEqualTo("Clean Code");
        assertThat(found.getPrice()).isEqualTo(29.99);
    }
}
