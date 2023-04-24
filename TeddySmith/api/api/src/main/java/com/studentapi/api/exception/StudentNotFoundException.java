package com.studentapi.api.exception;

public class StudentNotFoundException extends RuntimeException
{
   // private static final long serialVersionUId=1;

    public StudentNotFoundException(String msg)
    {
        super(msg);
    }

}
