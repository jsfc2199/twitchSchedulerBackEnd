package com.jsfc.streamprogrammer.route;

import com.jsfc.streamprogrammer.dto.UrlDto;
import com.jsfc.streamprogrammer.usecase.PutUrlUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutUrlRoute {
    @Bean
    public RouterFunction<ServerResponse> putUrl(PutUrlUseCase putUrlUseCase){
        return route(PUT("api/edit-url").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UrlDto.class)
                        .flatMap(urlDto -> putUrlUseCase.editUrl(urlDto))
                        .flatMap(urlDto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(urlDto)));
    }
}
