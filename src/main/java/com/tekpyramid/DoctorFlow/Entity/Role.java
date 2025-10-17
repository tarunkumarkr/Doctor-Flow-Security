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
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;
    private String roleName;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private List<User> userList;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private List<Doctor>doctorList;

    @OneToOne(mappedBy = "role")
    private Admin admin;
}
