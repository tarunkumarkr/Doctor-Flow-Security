package com.tekpyramid.DoctorFlow.Service;

import com.tekpyramid.DoctorFlow.Dto.DoctorInfoDTO;
import com.tekpyramid.DoctorFlow.Dto.DoctorLoginDTO;
import com.tekpyramid.DoctorFlow.Dto.DoctorSignUpDTO;
import com.tekpyramid.DoctorFlow.Entity.Doctor;
import com.tekpyramid.DoctorFlow.Entity.Role;
import com.tekpyramid.DoctorFlow.Entity.User;
import com.tekpyramid.DoctorFlow.Repository.DoctorRepository;
import com.tekpyramid.DoctorFlow.Repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    public DoctorRepository doctorRepository;

    @Autowired
    public RoleRepository roleRepository;


    @Override
    public String signUpDoctor(DoctorSignUpDTO doctorSignUpDTO) {

        Optional<Doctor> doctorExist= doctorRepository.findByEmail(doctorSignUpDTO.getEmail());

        if(doctorExist.isPresent()){
            throw new RuntimeException("Doctor details exists with this email:" + doctorSignUpDTO.getEmail());
        }

        Doctor doctor = new Doctor();
        BeanUtils.copyProperties(doctorSignUpDTO,doctor);

        Role doctorRole = roleRepository.findByRoleName("doctor");
        doctor.setRole(doctorRole);


        doctorRepository.save(doctor);

        return "Doctor registered successfully";
    }

    @Override
    public String loginDoctor(DoctorLoginDTO doctorLoginDTO) {

        Optional<Doctor>doctorEmailExist = doctorRepository.findByEmail(doctorLoginDTO.getEmail());

        if(doctorEmailExist.isEmpty()){
            throw new RuntimeException("Doctor not found with this email:"+doctorLoginDTO.getEmail());
        }
        Doctor doctor = doctorEmailExist.get();

        if(!doctor.getPassword().equals(doctorLoginDTO.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        return "Doctor Login Successful!!";
    }

    @Override
    public List<DoctorInfoDTO> findBydoctorNameContainingIgnoreCase(String doctorName) {

      List<Doctor> doctors = doctorRepository.findBydoctorNameContainingIgnoreCase(doctorName);

      if(doctors.isEmpty()){
          throw new RuntimeException("No doctors found with this match");
      }
      return  doctors.stream().map(doctor -> {
          DoctorInfoDTO dtoInfo = new DoctorInfoDTO();
          BeanUtils.copyProperties(doctor, dtoInfo);
          return dtoInfo;
      }).collect(Collectors.toList());


    }
}
