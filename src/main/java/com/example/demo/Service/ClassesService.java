package com.example.demo.Service;

import com.example.demo.domain.Classes;
import com.example.demo.dto.ClassesDTO;

import java.util.List;

public interface ClassesService {
    ClassesDTO findByCnumAndCname(String cnumber,String cname);
    List<Classes> findAllClasses();
}
