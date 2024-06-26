package com.CRUDJPA.controller;

import com.CRUDJPA.Entity.Courses;
import com.CRUDJPA.service.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class coursecontroller {
    @Autowired
   private Courseservice courseservice;

    @GetMapping
    public List<Courses> getallcourses(){
        return courseservice.getallcourses();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Courses> getbyid(@PathVariable Long id){
        Courses course = courseservice.getcoursebyid(id);
        if (course!=null) {
            return new ResponseEntity<>(courseservice.getcoursebyid(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /////////////////////////////////
    @PostMapping
    public Courses savecoursedetails(@RequestBody Courses courses){
        return courseservice.savecourses(courses);
    }
    /////////////////////////////////
    @PutMapping("/{id}")
    public ResponseEntity<Courses> updatecoursedetails(@PathVariable Long id, @RequestBody Courses coursedetails){
        Courses updatedcourse = courseservice.updatecourse(id,coursedetails);
        if(updatedcourse!=null){
            return new ResponseEntity<>(updatedcourse,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletecoursebyid(@PathVariable Long id){
        courseservice.deletecourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
