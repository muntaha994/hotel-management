package com.sicilia.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicilia.hotel.model.Student;
import com.sicilia.hotel.repositories.StudentRepo;

@RestController
public class MainController {

    @Autowired
    StudentRepo studentRepo;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        studentRepo.save(student);
    }

    // get by id
    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentRepo.findById(id).orElse(null);
    }

    // get all data
    @GetMapping("/getStudent")
    public List<Student> allStudents() {
        return studentRepo.findAll();
    }

    @PutMapping("/updateStudent/{id}")
    public void updateStudent(@RequestBody Student student) {
        // fetch data using id
        Student data = studentRepo.findById(student.getRno()).orElse(null);
        // check if null
        if (data != null) {
            data.setName(student.getName());
            data.setAddress(student.getAddress());
            studentRepo.save(data);
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepo.deleteById(id);
    }
}
