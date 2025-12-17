package com.example.demobooksspringbootapi.infrastructure.common.repositories;

import com.example.demobooksspringbootapi.infrastructure.common.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
