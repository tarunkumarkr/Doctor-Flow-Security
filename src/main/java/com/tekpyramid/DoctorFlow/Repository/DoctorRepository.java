package com.tekpyramid.DoctorFlow.Repository;

import com.tekpyramid.DoctorFlow.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {


    Optional<Doctor> findByEmail(String doctorEmail);


    List<Doctor> findBydoctorNameContainingIgnoreCase(String doctorName);

}
