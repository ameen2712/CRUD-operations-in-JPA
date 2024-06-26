package com.CRUDJPA.repository;

import com.CRUDJPA.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository <Student, Long> {
}
