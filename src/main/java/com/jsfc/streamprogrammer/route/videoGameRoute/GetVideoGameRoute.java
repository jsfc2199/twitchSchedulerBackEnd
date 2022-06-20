package com.jsfc.streamprogrammer.route.videoGameRoute;

import com.jsfc.streamprogrammer.dto.VideoGameDto;
import com.jsfc.streamprogrammer.usecase.videoGameUseCase.GetVideoGameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetVideoGameRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllVideoGames(GetVideoGameUseCase getVideoGameUseCase){
        return route(GET("/api/get-videogames"), request -> ServerResponse.status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getVideoGameUseCase.getVideoGames(),VideoGameDto.class)));
    }
}
