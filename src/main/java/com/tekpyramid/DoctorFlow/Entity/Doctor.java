package com.tekpyramid.DoctorFlow.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doctorId;
    private String doctorName;
    private String email;
    private String password;
    private long mobile;
    private String Specialist;
    private double rating;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    @OneToMany(mappedBy = "doctor" ,cascade = CascadeType.ALL)
    private List<LeaveRequest> leaveRequests;

    @OneToMany(mappedBy = "doctor" , cascade = CascadeType.ALL)
    private List<Appointment> appointmentLists;



}
