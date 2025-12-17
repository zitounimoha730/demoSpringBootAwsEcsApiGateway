package com.example.demobooksspringbootapi.infrastructure.commons.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
public class BookEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        @Column(nullable = false)
        String title;

        @Column(nullable = false)
        double price;

        boolean active;

        LocalDateTime horodateCreation;

        LocalDateTime horodateMaj;
}
