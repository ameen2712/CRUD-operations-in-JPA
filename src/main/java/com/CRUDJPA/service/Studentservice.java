package com.CRUDJPA.service;

import com.CRUDJPA.Entity.Student;
import com.CRUDJPA.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Studentservice {
    @Autowired
    private studentRepository studentrepository;

    public List<Student> getAllStudents(){
        return studentrepository.findAll();
    }
    public Student getStudentById(Long id){
        return studentrepository.findById(id).orElse(null);
    }
    public Student savestudent(Student student){
      return studentrepository.save(student);
    }
    public Student updateStudent(Long id, Student studentdetails){
        Student student = studentrepository.findById(id).orElse(null);
        if (student!=null){
            student.setStudentfirstname(studentdetails.getStudentfirstname());
            student.setStudentlastname(studentdetails.getStudentlastname());
            student.setStudentaddress(studentdetails.getStudentaddress());
            student.setStudentmail(studentdetails.getStudentmail());
            student.setStudentphoneno(studentdetails.getStudentphoneno());
            return studentrepository.save(student);
        }
        return null;
    }
    public void deletestudent(Long id){
        studentrepository.deleteById(id);
    }
}
