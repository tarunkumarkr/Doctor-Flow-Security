package com.tekpyramid.DoctorFlow.Dto;

import lombok.Data;

@Data
public class UserSignUpDTO {

    private String userName;
    private int age;
    private String sex;
    private String password;
    private long mobile;
    private String email;
}
