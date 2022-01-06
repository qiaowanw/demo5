package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    private ScoreMapper scoreMapper;

    @Test
    void findBySid() {
        System.out.println(scoreMapper.findBySid(23));
    }
}