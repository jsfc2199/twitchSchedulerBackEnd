package com.jsfc.streamprogrammer.route.videoGameRoute;

import com.jsfc.streamprogrammer.dto.VideoGameDto;
import com.jsfc.streamprogrammer.usecase.videoGameUseCase.PutVideoGameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutVideoGameRoute {

    @Bean
    public RouterFunction<ServerResponse> editVideoGame(PutVideoGameUseCase putVideoGameUseCase){
        return route(PUT("/api/update-videogame").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(VideoGameDto.class)
                        .flatMap(videoGameDto -> putVideoGameUseCase.updateVideoGame(videoGameDto))
                        .flatMap(videoGameDto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(videoGameDto)));
    }
}
