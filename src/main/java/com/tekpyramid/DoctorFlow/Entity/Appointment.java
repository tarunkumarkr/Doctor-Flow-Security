package com.tekpyramid.DoctorFlow.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.results.spi.LoadContexts;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private LocalDate createdDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

}
