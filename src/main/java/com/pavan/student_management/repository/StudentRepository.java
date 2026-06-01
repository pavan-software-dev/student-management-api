package com.pavan.student_management.repository;

import com.pavan.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByDepartment(String department);
}