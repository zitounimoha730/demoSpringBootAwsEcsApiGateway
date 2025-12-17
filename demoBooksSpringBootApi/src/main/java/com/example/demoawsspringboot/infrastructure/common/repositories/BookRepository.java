package com.example.demoawsspringboot.infrastructure.common.repositories;

import com.example.demoawsspringboot.infrastructure.common.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
