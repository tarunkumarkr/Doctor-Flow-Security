package com.tekpyramid.DoctorFlow.Entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;
    private String adminName;
    private  String adminPassword;

    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

}
