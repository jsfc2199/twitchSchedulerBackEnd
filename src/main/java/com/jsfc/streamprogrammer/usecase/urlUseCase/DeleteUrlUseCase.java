package com.jsfc.streamprogrammer.usecase.urlUseCase;

import com.jsfc.streamprogrammer.repository.UrlRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteUrlUseCase {
    private final UrlRepository repository;

    public DeleteUrlUseCase(UrlRepository repository) {
        this.repository = repository;
    }

    public Mono<Void> delebeById(String id){
        return repository.deleteById(id);
    }
}
