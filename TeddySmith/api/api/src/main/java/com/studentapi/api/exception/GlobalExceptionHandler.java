package com.studentapi.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice//For global exception handling
public class GlobalExceptionHandler
{

    @ExceptionHandler()
    public ResponseEntity<ErrorObject> handleExceptionStudentNotFound(StudentNotFoundException stud)
    {
        ErrorObject errorObject=new ErrorObject();
        errorObject.setCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMsg(stud.getMessage());
        errorObject.setTimestamp(new Date());

        return new ResponseEntity<>(errorObject,HttpStatus.NOT_FOUND);
    }

}
