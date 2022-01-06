package com.example.demo.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class StudentDTO {
    private String studentNum;
    private String studentName;
    private String className;
    private String address;
    private int age;
    private int chinese;
    private int math;
    private int english;
    private int total;
    private double avg;

    public void setAge(LocalDate birthday) {
        this.age = LocalDate.now().getYear()-birthday.getYear();
    }

    public void setTotal(int chinese, int math, int english) {
        this.total = chinese + math + english;
    }

    public void setAvg(int total) {
        this.avg = Math.round(total / 3.0);
    }
}
