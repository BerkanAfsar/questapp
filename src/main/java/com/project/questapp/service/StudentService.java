package com.project.questapp.service;

import com.project.questapp.entity.Post;
import com.project.questapp.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> getAllStudents();
}
