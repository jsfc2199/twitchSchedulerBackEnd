package com.jsfc.streamprogrammer.mapper;

import com.jsfc.streamprogrammer.collection.VideoGame;
import com.jsfc.streamprogrammer.dto.VideoGameDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class VideoGameMapper {
    public VideoGameDto fromVideoGameToDto(VideoGame videoGame){
        return new VideoGameDto(
                videoGame.getId(),
                videoGame.getName(),
                videoGame.getGenre(),
                videoGame.getUrl()
        );
    }

    public  VideoGame fromDtoToEntity(VideoGameDto videoGameDto){
        return new VideoGame(
                videoGameDto.getId(),
                videoGameDto.getName(),
                videoGameDto.getGenre(),
                videoGameDto.getUrl()
        );
    }
}
