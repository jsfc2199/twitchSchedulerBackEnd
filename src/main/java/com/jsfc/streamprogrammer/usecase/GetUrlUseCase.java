package com.jsfc.streamprogrammer.usecase;

import com.jsfc.streamprogrammer.dto.UrlDto;
import com.jsfc.streamprogrammer.mapper.UrlMapper;
import com.jsfc.streamprogrammer.repository.UrlRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetUrlUseCase {
    private final UrlRepository repository;
    private final UrlMapper mapper;

    public GetUrlUseCase(UrlRepository repository, UrlMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<UrlDto> getUrls(){
        return repository.findAll().map(url -> mapper.fromUrlToDto(url));
    }
}
