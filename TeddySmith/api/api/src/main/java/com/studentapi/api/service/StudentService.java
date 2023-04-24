package com.studentapi.api.service;

import com.studentapi.api.StduentDto.PageContent;
import com.studentapi.api.StduentDto.StudentDto;
import com.studentapi.api.exception.StudentNotFoundException;
import com.studentapi.api.model.Student;
import com.studentapi.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService
{
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository sr)
    {
        studentRepository=sr;
    }

    public StudentDto addStudents(StudentDto stud)
    {
        Student newStudent=new Student();
        newStudent.setId(stud.getId());
        newStudent.setName(stud.getName());
        newStudent.setBranch(stud.getBranch());



        Student result=studentRepository.save(newStudent);





        StudentDto dtoResult=new StudentDto();
        dtoResult.setId(result.getId());
        dtoResult.setName(result.getName());
        dtoResult.setBranch(result.getBranch());

        return dtoResult;

    }


    public PageContent getStudents(int pageNo,int pageSize)
    {

        PageRequest pageable=PageRequest.of(pageNo,pageSize);

         Page<Student> students= studentRepository.findAll((org.springframework.data.domain.Pageable) pageable);

        List<Student> student_result=students.getContent();



       List<StudentDto> content= student_result.stream().map(s->maptoDto(s)).collect(Collectors.toList());

        PageContent pageContent=new PageContent();
        pageContent.setContent(content);
        pageContent.setPageNo(students.getNumber());
        pageContent.setPageSize(students.getSize());
        pageContent.setLast(students.isLast());
        pageContent.setTotal_Page(students.getTotalPages());
        pageContent.setTotal_Element((int) students.getTotalElements());


        return pageContent;


    }

    private StudentDto maptoDto(Student s)
    {
      StudentDto studentDto=new StudentDto();
      studentDto.setId(s.getId());
      studentDto.setName(s.getName());
      studentDto.setBranch(s.getBranch());

      return studentDto;

    }

    public String deletes(int id)
    {
        if(id<0)
            throw new StudentNotFoundException("Student not found ");
        studentRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public StudentDto updateStudent(int id,StudentDto stud)
    {

        Student s=new Student();
//        s.setId(stud.getId());
//        s.setBranch(stud.getBranch());
//        s.setName(stud.getName());

        Optional<Student> result=studentRepository.findById(id);
        s=result.get();
        s.setName(stud.getName());
        s.setBranch(stud.getBranch());

        studentRepository.save(s);
        StudentDto sd=new StudentDto();

        //    sd.setId(result.getId());
        sd.setName(s.getName());
        sd.setBranch(s.getBranch());

        return sd;

    }

}
