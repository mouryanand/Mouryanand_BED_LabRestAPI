package com.example.student.DAO;

import com.example.student.domain.Student;

import java.util.List;

public interface IStudentDAO {

        void saveStudent(Student student);
        void updateStudent(Student student);
        void deleteStudent(Long studentId);
        Student getStudentById(Long studentId);
        List<Student> getAllStudents();


}
