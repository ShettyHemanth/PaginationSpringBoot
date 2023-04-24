package com.studentapi.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="student")

@NoArgsConstructor
@Getter
@Setter
public class Student
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="usn")
    int id;
    @Column(name="name")
    String name;

    public Student(String name, String branch) {
        this.name = name;
        this.branch = branch;
    }

    @Column(name="branch")
    String branch;

}
