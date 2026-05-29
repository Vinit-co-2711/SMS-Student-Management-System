package com.student.sms.controller;

import com.student.sms.model.Student;
import com.student.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping({"/", "/students"})
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);

        // Calculate statistics for the premium dashboard
        int totalStudents = students.size();
        double classAverage = 0;
        Student topStudent = null;

        if (totalStudents > 0) {
            double totalSum = 0;
            int maxMarks = -1;
            for (Student student : students) {
                totalSum += student.getTotalMarks();
                if (student.getTotalMarks() > maxMarks) {
                    maxMarks = student.getTotalMarks();
                    topStudent = student;
                }
            }
            classAverage = totalSum / totalStudents;
        }

        model.addAttribute("totalStudents", totalStudents);
        model.addAttribute("classAverage", Math.round(classAverage * 10.0) / 10.0);
        model.addAttribute("topStudent", topStudent != null ? topStudent.getName() : "N/A");

        return "index";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Add New Student");
        return "student-form";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student, Model model) {
        boolean hasError = false;

        // Perform custom validations for unique values
        if (!studentService.isRollNumberUnique(student.getRollNumber(), student.getId())) {
            model.addAttribute("rollNumberError", "Roll number must be unique.");
            hasError = true;
        }

        if (!studentService.isEmailUnique(student.getEmail(), student.getId())) {
            model.addAttribute("emailError", "Email address must be unique.");
            hasError = true;
        }

        if (hasError) {
            model.addAttribute("pageTitle", student.getId() == null ? "Add New Student" : "Edit Student");
            return "student-form";
        }

        if (student.getId() == null) {
            studentService.saveStudent(student);
        } else {
            studentService.updateStudent(student);
        }

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        try {
            Student student = studentService.getStudentById(id);
            model.addAttribute("student", student);
            model.addAttribute("pageTitle", "Edit Student");
            return "student-form";
        } catch (Exception e) {
            return "redirect:/students";
        }
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudentById(id);
        } catch (Exception e) {
            // Log or ignore
        }
        return "redirect:/students";
    }
}
