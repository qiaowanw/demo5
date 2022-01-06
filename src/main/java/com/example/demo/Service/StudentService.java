package com.example.demo.Service;

import com.example.demo.dto.StudentDTO;
import org.apache.ibatis.annotations.Param;



public interface StudentService {
    StudentDTO findByNumAndName(String number, String name);
    int generateSnumber();
}
