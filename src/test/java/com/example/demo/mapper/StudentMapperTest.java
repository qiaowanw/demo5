package com.example.demo.mapper;

import com.example.demo.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;


    @Test
    void findSidBySnumAndSname() {
        System.out.println(studentMapper.findSidBySnumAndSname("SN20220100005", "STU15"));

    }

    @Test
    void findStudentByCid() {
      studentMapper.findStudentByCid(2).forEach(System.out::println);
    }

    @Test
    void findSidBySname() {
        System.out.println(studentMapper.findSidBySname("STU24"));
    }

    @Test
    void save(){
        Student student=new Student();
        student.setNumber("aaa");
        studentMapper.save(student);
    }
}