package com.student.sms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "roll_number", nullable = false, unique = true)
    private String rollNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "math_marks", nullable = false)
    private int mathMarks;

    @Column(name = "science_marks", nullable = false)
    private int scienceMarks;

    @Column(name = "english_marks", nullable = false)
    private int englishMarks;

    @Column(name = "total_marks", nullable = false)
    private int totalMarks;

    @PrePersist
    @PreUpdate
    public void calculateTotalMarks() {
        this.totalMarks = this.mathMarks + this.scienceMarks + this.englishMarks;
    }
}
