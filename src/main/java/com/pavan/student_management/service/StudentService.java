package com.pavan.student_management.service;

import com.pavan.student_management.exception.StudentNotFoundException;
import com.pavan.student_management.model.Student;
import com.pavan.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new IllegalArgumentException("Student already exists with email: " + student.getEmail());
        }
        return studentRepository.save(student);
    }

    public Page<Student> getAllStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        return studentRepository.findAll(pageable);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = getStudentById(id);

        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setDepartment(updatedStudent.getDepartment());
        existing.setYear(updatedStudent.getYear());

        return studentRepository.save(existing);
    }

    public String deleteStudent(Long id) {
        Student existing = getStudentById(id);
        studentRepository.delete(existing);
        return "Student deleted successfully with id: " + id;
    }

    public List<Student> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Student> searchByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }
}