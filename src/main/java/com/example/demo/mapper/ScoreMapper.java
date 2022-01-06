package com.example.demo.mapper;

import com.example.demo.domain.Score;
import com.example.demo.dto.ScoreDTO;
import com.example.demo.form.Condition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ScoreMapper {
    Score findBySid(@Param("id") Integer sid); //sid查score
    List<ScoreDTO> findByCondition(Condition condition);
}
