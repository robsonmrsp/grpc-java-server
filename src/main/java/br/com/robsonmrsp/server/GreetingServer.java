package br.com.robsonmrsp.server;

import br.com.robsonmrsp.proto.HelloWorldMessageRequest;
import br.com.robsonmrsp.proto.HelloWorldMessageResponse;
import br.com.robsonmrsp.proto.HelloWorldServiceGrpc.HelloWorldServiceImplBase;
import io.grpc.stub.StreamObserver;

public class GreetingServer extends HelloWorldServiceImplBase {

	@Override
	public void sayHello(HelloWorldMessageRequest request, StreamObserver<HelloWorldMessageResponse> responseObserver) {
		super.sayHello(request, responseObserver);
		String myName = request.getMyName();

		HelloWorldMessageResponse build = HelloWorldMessageResponse.newBuilder().setGreeting("Hello, " + myName).build();

		responseObserver.onNext(build);
		responseObserver.onCompleted();
		;

	}
}
