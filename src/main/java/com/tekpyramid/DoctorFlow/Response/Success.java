package com.tekpyramid.DoctorFlow.Response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Success {

    private String message;
    private boolean error;
    private HttpStatus httpStatus;
    private Object data;
}
