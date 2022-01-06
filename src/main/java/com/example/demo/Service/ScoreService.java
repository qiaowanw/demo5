package com.example.demo.Service;

import com.example.demo.domain.Student;
import com.example.demo.dto.ScoreDTO;
import com.example.demo.form.Condition;

import java.util.List;

public interface ScoreService {
    List<ScoreDTO> findByCondition(Condition condition);
    List<Student> findSnameByCname(Integer cid); //级联
}
