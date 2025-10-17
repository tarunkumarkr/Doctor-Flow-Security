package com.tekpyramid.DoctorFlow.Exception;

import com.tekpyramid.DoctorFlow.Response.Failure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<Failure> duplicateRecordHandler(DuplicateRecordException exception){

        Failure failureResponse = new Failure();

        failureResponse.setData(null);
        failureResponse.setError(true);
        failureResponse.setHttpStatus(HttpStatus.CONFLICT);
        failureResponse.setMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(failureResponse);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> validationHandler(MethodArgumentNotValidException exception){

        Map<String,String> errors =new HashMap<>();

        List<FieldError> fieldErrors = exception.getFieldErrors();

        for(FieldError error: exception.getFieldErrors()){
            errors.put(error.getField(),error.getDefaultMessage());

        }
        return errors;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Failure> runTimeHandler(RuntimeException exception){
        Failure failureResponse = new Failure();
        failureResponse.setData(null);
        failureResponse.setError(true);
        failureResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        failureResponse.setMessage("Employee status not found" + exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureResponse);
    }

}
