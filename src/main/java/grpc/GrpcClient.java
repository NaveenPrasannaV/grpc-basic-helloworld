package grpc;


import grpc.Config.HelloReply;
import grpc.Config.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class GrpcClient {

  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
        .usePlaintext() // For simplicity
        .build();

    GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

    HelloRequest request = HelloRequest.newBuilder()
        .setName("World")
        .build();

    HelloReply response = stub.sayHello(request);
    System.out.println(response.getMessage());

    channel.shutdown();
  }
}
