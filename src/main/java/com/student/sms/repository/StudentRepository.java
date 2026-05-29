package com.student.sms.repository;

import com.student.sms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByRollNumber(String rollNumber);
    boolean existsByEmail(String email);
    
    // Check if roll number exists excluding a specific student ID (for updates)
    boolean existsByRollNumberAndIdNot(String rollNumber, Long id);
    boolean existsByEmailAndIdNot(String email, Long id);
}
