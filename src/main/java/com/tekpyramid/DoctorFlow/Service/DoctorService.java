package com.tekpyramid.DoctorFlow.Service;

import com.tekpyramid.DoctorFlow.Dto.DoctorInfoDTO;
import com.tekpyramid.DoctorFlow.Dto.DoctorLoginDTO;
import com.tekpyramid.DoctorFlow.Dto.DoctorSignUpDTO;

import java.util.List;

public interface DoctorService {

    String signUpDoctor(DoctorSignUpDTO doctorSignUpDTO);

    String loginDoctor(DoctorLoginDTO doctorLoginDTO);


    //List<DoctorInfoDTO> findDoctorByName(String doctorName);

    List<DoctorInfoDTO> findBydoctorNameContainingIgnoreCase(String doctorName);
}


