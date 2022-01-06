package com.example.demo.controller;

import com.example.demo.Service.ClassesService;
import com.example.demo.Service.ScoreService;
import com.example.demo.Service.StudentService;
import com.example.demo.domain.Classes;
import com.example.demo.domain.Student;
import com.example.demo.dto.ClassesDTO;
import com.example.demo.dto.ScoreDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.form.Condition;
import com.example.demo.mapper.ClassesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ClassesService classesService;


    @RequestMapping("/students")
    public StudentDTO students(String studentNumber, String studentName) {
        return studentService.findByNumAndName(studentNumber,studentName);
    }

    @RequestMapping("/classes")
    public ClassesDTO classes(String classesNumber, String classesName) {
        return classesService.findByCnumAndCname(classesNumber,classesName);
    }

    @RequestMapping("/scores")
    public List<ScoreDTO> scores(Condition condition) {
        System.out.println(condition);
        List<ScoreDTO> scoreDTOS = scoreService.findByCondition(condition);
        System.out.println(scoreDTOS);
        return scoreDTOS;
    }

    @RequestMapping("/allClasses")
    public List<Classes> allClasses(){
        return classesService.findAllClasses();
    }

    @RequestMapping("/allStudents")
    public List<Student> allStudents(Integer classesId){
        return scoreService.findSnameByCname(classesId);
    }

}
