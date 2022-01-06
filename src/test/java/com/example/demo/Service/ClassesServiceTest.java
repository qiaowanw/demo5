package com.example.demo.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ClassesServiceTest {

    @Autowired
    private ClassesService classesService;

    @Test
    void findByCnumAndCname() {
        System.out.println(classesService.findByCnumAndCname("CL202201003", "CLASS3"));
    }
}