package br.com.robsonmrsp;

import java.io.IOException;

import br.com.robsonmrsp.server.HelloWorldServiceImp;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Hello World!");
		Server server = ServerBuilder.forPort(8083).addService(new HelloWorldServiceImp()).build();

		server.start();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {

			server.shutdown();
		}));

		server.awaitTermination();
	}
}
