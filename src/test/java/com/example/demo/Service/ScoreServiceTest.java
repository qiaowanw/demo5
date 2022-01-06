package com.example.demo.Service;

import com.example.demo.form.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ScoreServiceTest {

    @Autowired
    private ScoreService scoreService;

    @Test
    void findByCondition() {
        Condition condition = new Condition();
       condition.setClassesName("CLASS4");
       condition.setStudentName("STU46");
      /*  condition.setAvgMax(90);
        condition.setAvgMin(85);*/
       //System.out.println(scoreService.findByCondition(condition));
       scoreService.findByCondition(condition).forEach(System.out::println);
    }

    @Test
    void findSnameByCname(){
        scoreService.findSnameByCname(5).forEach(System.out::println);
    }
}