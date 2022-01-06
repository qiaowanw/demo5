package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClassesMapperTest {

    @Autowired
    private ClassesMapper classesMapper;

    @Test
    void findCidByCnumAndCname() {
        System.out.println(classesMapper.findCidByCnumAndCname("CL202201003", "CLASS3"));
    }

    @Test
    void findCnameByCid() {
        System.out.println(classesMapper.findCnameByCid(4));
    }

    @Test
    void findAll(){
        classesMapper.findAllCname().forEach(System.out::println);
    }
}