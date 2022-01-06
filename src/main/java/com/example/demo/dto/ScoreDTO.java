package com.example.demo.dto;

import lombok.Data;

@Data
public class ScoreDTO {
    private String studentName;
    private String classesName;
    private Integer chinese;
    private Integer math;
    private Integer english;
    private double score;
}
