package com.example.demobooksspringbootapi.domain.book.create.ports;

import com.example.demobooksspringbootapi.domain.book.create.entity.CreateBookCommand;
import com.example.demobooksspringbootapi.domain.book.create.entity.CreateBookResponse;
import com.example.demobooksspringbootapi.domain.commons.entities.DefaultDomainService;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface CreateBookUseCase extends DefaultDomainService<CreateBookCommand, CreateBookResponse> {
}
