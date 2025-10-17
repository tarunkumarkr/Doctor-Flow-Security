package com.tekpyramid.DoctorFlow.Controller;

import com.tekpyramid.DoctorFlow.Dto.DoctorInfoDTO;
import com.tekpyramid.DoctorFlow.Dto.DoctorLoginDTO;
import com.tekpyramid.DoctorFlow.Dto.DoctorSignUpDTO;
import com.tekpyramid.DoctorFlow.Entity.Doctor;
import com.tekpyramid.DoctorFlow.Response.Success;
import com.tekpyramid.DoctorFlow.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/doctor")
public class DoctorController {

    @Autowired
    public DoctorService doctorService;

    @RequestMapping("/")
    public String request(){
        return "<h1>Hello World</h1>";
    }

    @PostMapping("/doctor-signUp")
    public ResponseEntity<Success> signUpDoctor(@RequestBody DoctorSignUpDTO doctorSignUpDTO){
        String signUpDoctor = doctorService.signUpDoctor(doctorSignUpDTO);
        Success successResponce = new Success();
        successResponce.setMessage("SignUp successfully done");
        successResponce.setError(false);
        successResponce.setHttpStatus(HttpStatus.ACCEPTED);
        successResponce.setData(null);

        return ResponseEntity.status(HttpStatus.ACCEPTED.value()).body(successResponce);
    }

    @PostMapping("/doctor-login")
    public ResponseEntity<Success> loginDoctor(@RequestBody DoctorLoginDTO doctorLoginDTO){

        String loginDoctor = doctorService.loginDoctor(doctorLoginDTO);
        Success successResponce = new Success();
        successResponce.setMessage(" Doctor Login successful");
        successResponce.setError(false);
        successResponce.setHttpStatus(HttpStatus.ACCEPTED);
        successResponce.setData(null);

        return ResponseEntity.status(HttpStatus.ACCEPTED.value()).body(successResponce);
    }

    @GetMapping("/doctor-info")
    public ResponseEntity<Success> findDoctor(@RequestParam ("DoctorName") String doctorName){
        List<DoctorInfoDTO> doctorlist = doctorService.findBydoctorNameContainingIgnoreCase(doctorName);
        Success successResponce = new Success();
        successResponce.setMessage(" Doctor info fetched successful");
        successResponce.setError(false);
        successResponce.setHttpStatus(HttpStatus.ACCEPTED);
        successResponce.setData(doctorlist);

        return ResponseEntity.status(HttpStatus.OK).body(successResponce);

    }
}
