package com.jsfc.streamprogrammer.route.videoGameRoute;

import com.jsfc.streamprogrammer.dto.VideoGameDto;
import com.jsfc.streamprogrammer.usecase.videoGameUseCase.PostCreateVideoGameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostVideoGameRoute {

    @Bean
    public RouterFunction<ServerResponse> createVideoGames(PostCreateVideoGameUseCase postCreateVideoGameUseCase){
        return route(POST("/api/create-videogame").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(VideoGameDto.class)
                        .flatMap(postCreateVideoGameUseCase::saveVideoGame)
                        .flatMap(videoGameDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(videoGameDto)));
    }
}
