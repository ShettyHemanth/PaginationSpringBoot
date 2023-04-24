package com.studentapi.api.controller;

import com.studentapi.api.StduentDto.PageContent;
import com.studentapi.api.StduentDto.StudentDto;
import com.studentapi.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{

    StudentService ss;

    @Autowired
    public StudentController(StudentService studentService)
    {
        ss=studentService;
    }
    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public StudentDto addStudents(@RequestBody StudentDto stud)
    {
           return ss.addStudents(stud);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/details")
    public PageContent getStudents(
            @RequestParam(value="pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(value="pageSize",defaultValue = "5",required = false)int pageSize
    )
    {
        return ss.getStudents(pageNo,pageSize);
    }


    @RequestMapping(method = RequestMethod.DELETE,value = "/deleted/{id}")
    public String deleted(@PathVariable int id)
    {
          return ss.deletes(id);
    }


    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}")
    public StudentDto updated(@PathVariable int id,@RequestBody StudentDto stud)
    {
       return ss.updateStudent(id,stud);
    }



}
