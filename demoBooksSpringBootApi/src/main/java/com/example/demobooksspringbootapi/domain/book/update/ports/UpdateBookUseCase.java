package com.example.demobooksspringbootapi.domain.book.update.ports;

import com.example.demobooksspringbootapi.domain.book.update.entity.UpdateBookCommand;
import com.example.demobooksspringbootapi.domain.book.update.entity.UpdateBookResponse;
import com.example.demobooksspringbootapi.domain.commons.entities.DefaultDomainService;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface UpdateBookUseCase extends DefaultDomainService<UpdateBookCommand, UpdateBookResponse> {
}
