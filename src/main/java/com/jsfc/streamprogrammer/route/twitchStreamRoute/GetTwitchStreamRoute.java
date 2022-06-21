package com.jsfc.streamprogrammer.route.twitchStreamRoute;

import com.jsfc.streamprogrammer.dto.TwitchStreamDto;
import com.jsfc.streamprogrammer.usecase.twitchStreamUseCase.GetTwitchStreamUseCase;
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
public class GetTwitchStreamRoute {
    @Bean
    public RouterFunction<ServerResponse> getAllStreams(GetTwitchStreamUseCase getTwitchStreamUseCase){
        return route(GET("/api/get-twitch-streams"), request -> ServerResponse.status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getTwitchStreamUseCase.getAllStreams(), TwitchStreamDto.class)));
    }
}
