package com.example.rsocketclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RsocketclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsocketclientApplication.class, args);
	}

//	@Bean
//	RSocket rSocket() {
//		return new RSocketServerFactory().create();
//	}
//
//	@Bean
//	RSocketRequester requester(RSocketStrategies strategies) {
//		return RSocketRequester.wrap(this.rSocket(),
//				MimeTypeUtils.APPLICATION_JSON,
//				MimeTypeUtils.APPLICATION_JSON,
//				strategies);
//	}

}
