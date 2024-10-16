package grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

  public static void main(String[] args) throws Exception {
    Server server = ServerBuilder.forPort(8081)
        .addService(new GreeterService()) // Use the generated class
        .build();
    server.start();
    System.out.println("Server started at " + server.getPort());
    server.awaitTermination();
  }
}
