package com.jsfc.streamprogrammer.usecase.videoGameUseCase;

import com.jsfc.streamprogrammer.dto.VideoGameDto;
import com.jsfc.streamprogrammer.mapper.VideoGameMapper;
import com.jsfc.streamprogrammer.repository.VideoGameRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetVideoGameUseCase {
    private final VideoGameRepository repository;
    private final VideoGameMapper mapper;

    public GetVideoGameUseCase(VideoGameRepository repository, VideoGameMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<VideoGameDto> getVideoGames(){
        return repository.findAll().map(videoGame -> mapper.fromVideoGameToDto(videoGame));
    }
}
