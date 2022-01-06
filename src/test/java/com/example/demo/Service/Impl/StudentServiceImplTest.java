package com.example.demo.Service.Impl;

import com.example.demo.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;

    @Test
    void findByNumAndName() {
        System.out.println(studentService.findByNumAndName("SN20220100002", "STU22"));
    }

    @Test
    void generateSnumber(){
        studentService.generateSnumber();
    }
}