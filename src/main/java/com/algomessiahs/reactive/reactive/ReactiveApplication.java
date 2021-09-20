package com.algomessiahs.reactive.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.*;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class ReactiveApplication {

	final Sinks.Many sink;
	final AtomicLong counter;
	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}



	public ReactiveApplication() {
		this.sink = Sinks.many().multicast().onBackpressureBuffer();
		this.counter = new AtomicLong();
	}

	@CrossOrigin
	@GetMapping("/send")
	public void test() {
		Sinks.EmitResult result = sink.tryEmitNext("Hello World #" + counter.getAndIncrement());

		if (result.isFailure()) {
			// do something here, since emission failed
		}
	}

	@CrossOrigin
	@GetMapping(value="get",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ServerSentEvent> sse() {
		return sink.asFlux().map(e -> ServerSentEvent.builder(e).build());
	}
}
