package com.jsfc.streamprogrammer.usecase.videoGameUseCase;

import com.jsfc.streamprogrammer.dto.VideoGameDto;
import com.jsfc.streamprogrammer.mapper.VideoGameMapper;
import com.jsfc.streamprogrammer.repository.VideoGameRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostCreateVideoGameUseCase {
    private final VideoGameRepository repository;
    private final VideoGameMapper mapper;

    public PostCreateVideoGameUseCase(VideoGameRepository repository, VideoGameMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<VideoGameDto> saveVideoGame(VideoGameDto videoGameDto){
        return repository.save(mapper.fromDtoToEntity(videoGameDto)).map(videoGame -> mapper.fromVideoGameToDto(videoGame));
    }
}
