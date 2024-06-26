package com.CRUDJPA.repository;

import com.CRUDJPA.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepository extends JpaRepository<Courses,Long> {
}
