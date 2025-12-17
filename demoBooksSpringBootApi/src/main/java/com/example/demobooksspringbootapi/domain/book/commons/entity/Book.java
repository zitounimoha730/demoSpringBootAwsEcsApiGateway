package com.example.demoarchitecturehexagonal.domain.book.commons.entity;

import lombok.Builder;
import lombok.With;

import java.time.LocalDateTime;

@Builder
@With
public record Book(String id,
                   String title,
                   Double price,
                   Boolean active,
                   LocalDateTime horodateCreation,
                   LocalDateTime horodateMaj) {
}
