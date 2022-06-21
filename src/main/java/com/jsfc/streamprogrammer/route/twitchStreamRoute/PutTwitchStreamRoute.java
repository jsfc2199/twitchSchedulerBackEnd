package com.jsfc.streamprogrammer.route.twitchStreamRoute;

import com.jsfc.streamprogrammer.dto.TwitchStreamDto;
import com.jsfc.streamprogrammer.usecase.twitchStreamUseCase.PutTwitchStreamUseCase;
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
public class PutTwitchStreamRoute {
    @Bean
    public RouterFunction<ServerResponse> editTwitchStream(PutTwitchStreamUseCase putTwitchStreamUseCase){
        return route(PUT("/api/update-twitch-stream").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TwitchStreamDto.class)
                        .flatMap(twitchStreamDto -> putTwitchStreamUseCase.updateStream(twitchStreamDto))
                        .flatMap(twitchStreamDto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(twitchStreamDto)));
    }
}
