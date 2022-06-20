package com.jsfc.streamprogrammer.mapper;

import com.jsfc.streamprogrammer.collection.Url;
import com.jsfc.streamprogrammer.dto.UrlDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class UrlMapper {

    public UrlDto fromUrlToDto(Url url){
        UrlDto dto = new UrlDto();
        dto.setId(url.getId());
        dto.setWebSiteName(url.getWebSiteName());
        dto.setWebSiteUrl(url.getWebSiteUrl());

        return dto;
    }

    public Url fromDtoToUrl(UrlDto urlDto){
        Url entity = new Url();
        entity.setId(urlDto.getId());
        entity.setWebSiteName(urlDto.getWebSiteName());
        entity.setWebSiteUrl(urlDto.getWebSiteUrl());

        return entity;
    }
}
