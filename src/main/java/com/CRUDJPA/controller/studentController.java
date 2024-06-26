package com.CRUDJPA.controller;

import com.CRUDJPA.Entity.Student;
import com.CRUDJPA.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentController {
     @Autowired
    Studentservice studentservice;
     ///////////////////////////////////
     @GetMapping
    public List<Student> getAllStudents(){
         return studentservice.getAllStudents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getelementbyid(@PathVariable Long id){
         Student student = studentservice.getStudentById(id);
         if (student!=null){
             return new ResponseEntity<>(student, HttpStatus.OK);
         }
         else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
    //////////////////////////////////////
    @PostMapping
    public Student createstudent(@RequestBody Student student){
         return studentservice.savestudent(student);
    }
    //////////////////////////////////////
    @PutMapping("/{id}")
    public ResponseEntity<Student> updatestudent(@PathVariable Long id,@RequestBody Student studentdetails){
         Student updatestudent = studentservice.updateStudent(id,studentdetails);
         if (updatestudent!=null){
             return new ResponseEntity<>(updatestudent,HttpStatus.OK);
         }
         else{
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
    ////////////////////////////////////////////
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletestudent(long id){
         studentservice.deletestudent(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
