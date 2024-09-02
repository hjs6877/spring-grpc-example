package com.itvillage.grpc;

import com.itvillage.grpc.lib.HelloRequest;
import com.itvillage.grpc.lib.MyServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class MyServiceClient {
    @GrpcClient("local-grpc-server")
    private MyServiceGrpc.MyServiceBlockingStub myServiceStub;

    public String requestGreeting(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return myServiceStub.sayHello(request).getMessage();
    }
}