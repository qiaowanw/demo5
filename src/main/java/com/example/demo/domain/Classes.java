package com.example.demo.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Classes {
    private Integer id;
    private String number;
    private  String name;
    private Integer status;
    private String creator;
    private LocalDateTime createTime;
    private String operator;
    private LocalDateTime operateTime;
}
