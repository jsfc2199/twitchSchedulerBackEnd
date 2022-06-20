package com.jsfc.streamprogrammer.usecase;

import com.jsfc.streamprogrammer.dto.UrlDto;
import com.jsfc.streamprogrammer.mapper.UrlMapper;
import com.jsfc.streamprogrammer.repository.UrlRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PutUrlUseCase {
    private final UrlRepository repository;
    private final UrlMapper mapper;

    public PutUrlUseCase(UrlRepository repository, UrlMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<UrlDto> editUrl(UrlDto urlDto){
        return repository.save(mapper.fromDtoToUrl(urlDto)).map(url -> mapper.fromUrlToDto(url));
    }
}
