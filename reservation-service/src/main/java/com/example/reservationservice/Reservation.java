package com.example.reservationservice;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    private String id;

    private String name;

}
