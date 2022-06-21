package com.jsfc.streamprogrammer.usecase.twitchStreamUseCase;

import com.jsfc.streamprogrammer.dto.TwitchStreamDto;
import com.jsfc.streamprogrammer.mapper.TwitchStreamMapper;
import com.jsfc.streamprogrammer.repository.TwitchStreamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetTwitchStreamUseCase {
    private final TwitchStreamRepository repository;
    private final TwitchStreamMapper mapper;

    public GetTwitchStreamUseCase(TwitchStreamRepository repository, TwitchStreamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<TwitchStreamDto> getAllStreams(){
        return repository.findAll().map(twitchStream -> mapper.fromTwitchStreamToDto(twitchStream));
    }
}
