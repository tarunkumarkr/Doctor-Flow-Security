package com.tekpyramid.DoctorFlow.Controller;

import com.tekpyramid.DoctorFlow.Dto.DoctorLoginDTO;
import com.tekpyramid.DoctorFlow.Dto.UserLoginDTO;
import com.tekpyramid.DoctorFlow.Dto.UserSignUpDTO;
import com.tekpyramid.DoctorFlow.Response.Success;
import com.tekpyramid.DoctorFlow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/")
    public String request(){
        return "<h1>Hello World</h1>";
    }

    @PostMapping("/user/signup")
    public ResponseEntity<Success>signUpUser(@RequestBody UserSignUpDTO userSignUpDTO){

        String signUpUser= userService.signUpUser(userSignUpDTO);
        Success successResponce = new Success();
        successResponce.setMessage(" User SignUp successfully done");
        successResponce.setError(false);
        successResponce.setHttpStatus(HttpStatus.ACCEPTED);
        successResponce.setData(null);

        return ResponseEntity.status(HttpStatus.ACCEPTED.value()).body(successResponce);

    }

    @PostMapping("/user-login")
    public ResponseEntity<Success> loginDoctor(@RequestBody UserLoginDTO userLoginDTO){

        String loginDoctor = userService.loginUser(userLoginDTO);
        Success successResponce = new Success();
        successResponce.setMessage(" User Login successful");
        successResponce.setError(false);
        successResponce.setHttpStatus(HttpStatus.ACCEPTED);
        successResponce.setData(null);

        return ResponseEntity.status(HttpStatus.ACCEPTED.value()).body(successResponce);
    }
    public static  void get(){
        System.out.println("hbfjdhhjdb");
    }
}
