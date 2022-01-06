package com.example.demo.dto;

import lombok.Data;

@Data
public class ClassesDTO {
    private String classesNumber;
    private String classesName;
    private double avgChinese;
    private double avgMath;
    private double avgEnglish;
    private double avgTotal;

    public void setAvgTotal(double avgChinese,double avgMath,double avgEnglish) {
        this.avgTotal = avgChinese + avgMath + avgEnglish;
    }
}
