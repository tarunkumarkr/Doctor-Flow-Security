package com.tekpyramid.DoctorFlow.Service;

import com.tekpyramid.DoctorFlow.Dto.UserLoginDTO;
import com.tekpyramid.DoctorFlow.Dto.UserSignUpDTO;

public interface UserService {
    String signUpUser(UserSignUpDTO userSignUpDTO);

    String loginUser(UserLoginDTO userLoginDTO);
}


