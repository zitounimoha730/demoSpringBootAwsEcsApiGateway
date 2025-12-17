package com.example.demoawsspringboot.domain.book.readall.ports;

import com.example.demoawsspringboot.domain.book.readall.entity.ReadAllBooksCommand;
import com.example.demoawsspringboot.domain.book.readall.entity.ReadAllBooksResponse;
import com.example.demoawsspringboot.domain.common.entities.DefaultDomainService;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface ReadAllBooksUseCase extends DefaultDomainService<ReadAllBooksCommand, ReadAllBooksResponse> {
}
