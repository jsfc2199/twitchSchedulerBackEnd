package com.jsfc.streamprogrammer.route.twitchStreamRoute;

import com.jsfc.streamprogrammer.usecase.twitchStreamUseCase.DeleteTwitchStreamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteTwitchStreamRoute {
    @Bean
    public RouterFunction<ServerResponse> deleteStream(DeleteTwitchStreamUseCase deleteTwitchStreamUseCase){
        return route(DELETE("/api/delete-twitch-stream/{id}"), request-> ServerResponse.status(HttpStatus.ACCEPTED)
                .build(deleteTwitchStreamUseCase.deletetwitchStream(request.pathVariable("id"))));
    }
}
