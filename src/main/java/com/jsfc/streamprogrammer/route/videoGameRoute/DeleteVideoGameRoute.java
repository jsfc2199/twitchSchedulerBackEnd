package com.jsfc.streamprogrammer.route.videoGameRoute;

import com.jsfc.streamprogrammer.usecase.videoGameUseCase.DeleteVideoGameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteVideoGameRoute {
    @Bean
    public RouterFunction<ServerResponse> deleteVideoGame(DeleteVideoGameUseCase deleteVideoGameUseCase) {
        return route(DELETE("/api/delete-videogame/{id}"),
                request -> ServerResponse.status(HttpStatus.ACCEPTED)
                        .build(deleteVideoGameUseCase.deleteVideoGame(request.pathVariable("id"))));
    }
}
