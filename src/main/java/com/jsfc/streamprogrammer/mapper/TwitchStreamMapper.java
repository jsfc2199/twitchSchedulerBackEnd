package com.jsfc.streamprogrammer.mapper;

import com.jsfc.streamprogrammer.collection.TwitchStream;
import com.jsfc.streamprogrammer.dto.TwitchStreamDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class TwitchStreamMapper {
    public TwitchStreamDto fromTwitchStreamToDto(TwitchStream twitchStream){
        return new TwitchStreamDto(
                twitchStream.getId(),
                twitchStream.getDay(),
                twitchStream.getCategory(),
                twitchStream.getVideoGameList()
        );
    }

    public TwitchStream fromDtoToEntity(TwitchStreamDto twitchStreamDto){
        return new TwitchStream(
                twitchStreamDto.getId(),
                twitchStreamDto.getDay(),
                twitchStreamDto.getCategory(),
                twitchStreamDto.getVideoGameList()
        );
    }
}
