package com.tekpyramid.DoctorFlow.Exception;

public class DuplicateRecordException extends RuntimeException {
    public DuplicateRecordException(String message) {
        super("Duplicate Record Already Exist");
    }
}
