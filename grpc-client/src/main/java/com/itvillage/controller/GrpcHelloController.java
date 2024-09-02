package com.itvillage.controller;

import com.itvillage.dto.MessageDto;
import com.itvillage.grpc.MyServiceClient;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GrpcHelloController {
    private final MyServiceClient myServiceClient;

    public GrpcHelloController(MyServiceClient myServiceClient) {
        this.myServiceClient = myServiceClient;
    }

    @PostMapping("/messages")
    public Mono<String> postMessage(@RequestBody MessageDto messageDto) {
        return Mono.just(myServiceClient.requestGreeting(messageDto.getMessage()));
    }
}
