package com.jsfc.streamprogrammer.usecase.twitchStreamUseCase;

import com.jsfc.streamprogrammer.repository.TwitchStreamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteTwitchStreamUseCase {
    private final TwitchStreamRepository repository;

    public DeleteTwitchStreamUseCase(TwitchStreamRepository repository) {
        this.repository = repository;
    }

    public Mono<Void> deletetwitchStream(String id){
        return repository.deleteById(id);
    }
}
