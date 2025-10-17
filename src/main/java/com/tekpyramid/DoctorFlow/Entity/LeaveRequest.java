package com.tekpyramid.DoctorFlow.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int leaveId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;
    private String Status;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;
}
