package com.jsfc.streamprogrammer.route;

import com.jsfc.streamprogrammer.dto.UrlDto;
import com.jsfc.streamprogrammer.usecase.PostCreateUrlUseCase;
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
public class PostCreateUrlRoute {

    @Bean
    public RouterFunction<ServerResponse> createUrl(PostCreateUrlUseCase postCreateUrlUseCase){
        return route(POST("/api/create-url").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UrlDto.class)
                        .flatMap(urlDto -> postCreateUrlUseCase.saveUrl(urlDto))
                        .flatMap(urlDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(urlDto)));
    }
}
