package com.example.demoawsspringboot.domain.book.create.ports;

import com.example.demoawsspringboot.domain.book.create.entity.CreateBookCommand;
import com.example.demoawsspringboot.domain.book.create.entity.CreateBookResponse;
import com.example.demoawsspringboot.domain.common.entities.DefaultDomainService;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface CreateBookUseCase extends DefaultDomainService<CreateBookCommand, CreateBookResponse> {
}
