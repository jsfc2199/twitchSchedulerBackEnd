package com.jsfc.streamprogrammer.usecase.videoGameUseCase;

import com.jsfc.streamprogrammer.repository.VideoGameRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteVideoGameUseCase {
    private final VideoGameRepository repository;

    public DeleteVideoGameUseCase(VideoGameRepository repository) {
        this.repository = repository;
    }

    public Mono<Void> deleteVideoGame(String id){
        return repository.deleteById(id);
    }
}
