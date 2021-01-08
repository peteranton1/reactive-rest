package com.example.reservationservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
class GreetingRequest {
    private String name;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class GreetingResponse {
    private String greeting;
}

@Component
public class IntervalMessageProducer {

    Flux<GreetingResponse> produceGreetings(GreetingRequest name) {
        return Flux.fromStream(Stream.generate(
                () -> "Hello " + name.getName() + " @ " + Instant.now()))
                .map(GreetingResponse::new)
                .delayElements(Duration.ofSeconds(1));
    }
}
