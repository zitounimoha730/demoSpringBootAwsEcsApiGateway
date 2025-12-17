package com.example.demoarchitecturehexagonal.domain.book.update.ports;

import com.example.demoarchitecturehexagonal.domain.book.update.entity.UpdateBookCommand;
import com.example.demoarchitecturehexagonal.domain.book.update.entity.UpdateBookResponse;
import com.example.demoarchitecturehexagonal.domain.commons.entities.DefaultDomainService;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface UpdateBookUseCase extends DefaultDomainService<UpdateBookCommand, UpdateBookResponse> {
}
