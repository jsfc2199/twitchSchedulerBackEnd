package com.jsfc.streamprogrammer.route.urlRoute;

import com.jsfc.streamprogrammer.usecase.urlUseCase.DeleteUrlUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteUrlRoute {
    @Bean
    public RouterFunction<ServerResponse> deleteUrlById(DeleteUrlUseCase deleteUrlUseCase) {
        return route(DELETE("/api/delete-url/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.ACCEPTED)
                        .build(deleteUrlUseCase.delebeById(request.pathVariable("id"))));
    }
}
