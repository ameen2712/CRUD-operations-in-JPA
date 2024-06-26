package com.CRUDJPA.service;

import com.CRUDJPA.Entity.Courses;
import com.CRUDJPA.repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Courseservice {
    @Autowired
    private courseRepository courserepository;

    public List<Courses> getallcourses(){
        return courserepository.findAll();
    }
    public Courses getcoursebyid(long Id){
        return courserepository.findById(Id).orElse(null);
    }
    public Courses savecourses(Courses course){
        return courserepository.save(course);
    }
    public Courses updatecourse(Long id,Courses coursedetails){
        Courses course = courserepository.findById(id).orElse(null);
        if (course != null) {
            course.setCoursename(coursedetails.getCoursename());
            return courserepository.save(course);
        }
        return null;
    }
    public void deletecourse(Long id){
       courserepository.deleteById(id);
    }
}
