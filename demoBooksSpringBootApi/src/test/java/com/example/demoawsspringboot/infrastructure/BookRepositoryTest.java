package com.example.demoawsspringboot.infrastructure;

import com.example.demoawsspringboot.infrastructure.common.entities.BookEntity;
import com.example.demoawsspringboot.infrastructure.common.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldSaveAndFindBook() {
        BookEntity book = new BookEntity(null, "Clean Code", 29.99);

        BookEntity saved = bookRepository.save(book);

        assertThat(saved.id()).isNotNull();

        BookEntity found = bookRepository.findById(saved.id()).orElseThrow();

        assertThat(found.title()).isEqualTo("Clean Code");
        assertThat(found.price()).isEqualTo(29.99);
    }
}
