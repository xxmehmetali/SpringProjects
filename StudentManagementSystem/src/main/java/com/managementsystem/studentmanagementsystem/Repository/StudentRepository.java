package com.managementsystem.studentmanagementsystem.Repository;

import com.managementsystem.studentmanagementsystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// we do not need to add @Repository annotation just because SimpleJpaRepository interface implements the @Repository annotation.
public interface StudentRepository extends JpaRepository<Student, Long> {

}
