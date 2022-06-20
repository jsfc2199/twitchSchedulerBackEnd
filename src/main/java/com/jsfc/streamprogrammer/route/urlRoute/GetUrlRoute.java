package com.jsfc.streamprogrammer.route.urlRoute;

import com.jsfc.streamprogrammer.dto.UrlDto;
import com.jsfc.streamprogrammer.usecase.urlUseCase.GetUrlUseCase;
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
public class GetUrlRoute {
    @Bean
    public RouterFunction<ServerResponse> getUrls(GetUrlUseCase getUrlUseCase){
        return route(GET("/api/get-urls"), request -> ServerResponse.status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getUrlUseCase.getUrls(), UrlDto.class)));
    }
}
