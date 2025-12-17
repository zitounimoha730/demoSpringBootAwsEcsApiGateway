package com.example.demobooksspringbootapi.domain.book.readall.ports;

import com.example.demobooksspringbootapi.domain.book.readall.entity.ReadAllBooksCommand;
import com.example.demobooksspringbootapi.domain.book.readall.entity.ReadAllBooksResponse;
import com.example.demobooksspringbootapi.domain.commons.entities.DefaultDomainService;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface ReadAllBooksUseCase extends DefaultDomainService<ReadAllBooksCommand, ReadAllBooksResponse> {
}
