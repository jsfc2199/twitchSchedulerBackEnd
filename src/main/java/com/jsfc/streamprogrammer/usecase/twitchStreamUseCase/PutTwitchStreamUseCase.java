package com.jsfc.streamprogrammer.usecase.twitchStreamUseCase;

import com.jsfc.streamprogrammer.dto.TwitchStreamDto;
import com.jsfc.streamprogrammer.mapper.TwitchStreamMapper;
import com.jsfc.streamprogrammer.repository.TwitchStreamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PutTwitchStreamUseCase {
    private final TwitchStreamRepository repository;
    private final TwitchStreamMapper mapper;

    public PutTwitchStreamUseCase(TwitchStreamRepository repository, TwitchStreamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<TwitchStreamDto> updateStream(TwitchStreamDto twitchStreamDto){
        return repository.save(mapper.fromDtoToEntity(twitchStreamDto)).map(twitchStream -> mapper.fromTwitchStreamToDto(twitchStream));
    }
}
