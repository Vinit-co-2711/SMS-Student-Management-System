package com.student.sms.service.impl;

import com.student.sms.model.Student;
import com.student.sms.repository.StudentRepository;
import com.student.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        student.calculateTotalMarks();
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for id: " + id));
    }

    @Override
    public Student updateStudent(Student student) {
        student.calculateTotalMarks();
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public boolean isRollNumberUnique(String rollNumber, Long id) {
        if (id == null) {
            return !studentRepository.existsByRollNumber(rollNumber);
        } else {
            return !studentRepository.existsByRollNumberAndIdNot(rollNumber, id);
        }
    }

    @Override
    public boolean isEmailUnique(String email, Long id) {
        if (id == null) {
            return !studentRepository.existsByEmail(email);
        } else {
            return !studentRepository.existsByEmailAndIdNot(email, id);
        }
    }
}
