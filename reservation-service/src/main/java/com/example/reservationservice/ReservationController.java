package com.example.reservationservice;

import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final IntervalMessageProducer imp;

    @GetMapping("/reservations")
    public Publisher<Reservation> getReservations() {
        return this.reservationRepository.findAll();
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/sse/{n}")
    Publisher<GreetingResponse> sse(@PathVariable String n) {
        return this.imp.produceGreetings(new GreetingRequest(n));
    }
}
