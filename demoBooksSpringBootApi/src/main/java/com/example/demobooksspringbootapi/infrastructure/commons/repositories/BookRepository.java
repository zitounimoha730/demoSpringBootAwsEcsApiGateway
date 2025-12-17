package com.example.demobooksspringbootapi.infrastructure.commons.repositories;

import com.example.demobooksspringbootapi.infrastructure.commons.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
