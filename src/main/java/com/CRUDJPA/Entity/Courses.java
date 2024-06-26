package com.CRUDJPA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "course_name")
    private String coursename;
    ////////////////////////////////////////////////////////////////////////
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    //////////////////////////////////////////////////////////////////////////
}
