package com.student.sms.service;

import com.student.sms.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudentById(Long id);
    
    // Validation methods to check unique fields before saving
    boolean isRollNumberUnique(String rollNumber, Long id);
    boolean isEmailUnique(String email, Long id);
}
