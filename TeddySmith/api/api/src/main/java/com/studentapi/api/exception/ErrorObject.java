package com.studentapi.api.exception;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorObject
{
  int code;


  String msg;

  Date timestamp;


}
