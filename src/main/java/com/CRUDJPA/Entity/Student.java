package com.CRUDJPA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String studentfirstname;
    @Column(name = "Address")
    private String studentaddress;
    @Column(name = "last_name")
    private String studentlastname;
    @Column(name = "mail_id")
    private String studentmail;
    @Column(name = "Phone_number")
    private String studentphoneno;
 ///////////////////////////////////////////////////////////////////////////////////
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = false)
    private List<Courses> courses;
    //////////////////////////////////////////////////////////////////////////////
}
