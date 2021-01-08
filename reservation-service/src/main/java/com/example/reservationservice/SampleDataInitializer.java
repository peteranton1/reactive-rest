package com.example.reservationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Slf4j
@Component
public class SampleDataInitializer {

    //private static final Logger log = LoggerFactory.getLogger(SampleDataInitializer.class);

    private final ReservationRepository reservationRepository;

    @Autowired
    public SampleDataInitializer(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initialize() {
        var saved = Flux
                .just("Josh", "Cornelia", "Dr. Syer", "Violetta",
                        "Stephane", "Olga", "Sebastien", "Madhura")
                .map(name -> Reservation.builder().name(name).build())
                .flatMap(this.reservationRepository::save);

        this.reservationRepository.deleteAll()
                .thenMany(saved)
                .thenMany(this.reservationRepository.findAll())
                .subscribe(v -> log.info(String.valueOf(v)));
    }
}
