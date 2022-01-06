package com.example.demo.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Student {
    private Integer id;
    private String number;
    private String name;
    private Sex sex;
    private LocalDate birthday;
    private Integer age;
    private String address;
    private String tel;
    private Classes classes;
    private Integer status;
    private String creator;
    private LocalDateTime createTime;
    private String operator;
    private LocalDateTime operateTime;
}
