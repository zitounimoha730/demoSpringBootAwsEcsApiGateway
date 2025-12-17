package com.example.demobooksspringbootapi.application.rest.book.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.With;

import java.time.LocalDateTime;

@With
public record BookDto(@JsonProperty(access = JsonProperty.Access.READ_ONLY)
                      Long id,
                      @NotBlank(message = "Title is required!")
                      String title,
                      @NotNull(message = "Title is required!")
                      @PositiveOrZero(message = "Price can't be negative!")
                      double price,
                      boolean active,
                      LocalDateTime horodateCreation,
                      LocalDateTime horodateMaj) { }
