package com.jsfc.streamprogrammer.usecase.urlUseCase;

import com.jsfc.streamprogrammer.dto.UrlDto;
import com.jsfc.streamprogrammer.mapper.UrlMapper;
import com.jsfc.streamprogrammer.repository.UrlRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostCreateUrlUseCase {
    private final UrlRepository repository;
    private final UrlMapper mapper;

    public PostCreateUrlUseCase(UrlRepository repository, UrlMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<UrlDto> saveUrl(UrlDto urlDto){
        return repository.save(mapper.fromDtoToUrl(urlDto)).map(url -> mapper.fromUrlToDto(url));
    }
}
