package com.example.demo.Service.Impl;

import com.example.demo.Service.ClassesService;
import com.example.demo.domain.Classes;
import com.example.demo.domain.Student;
import com.example.demo.dto.ClassesDTO;
import com.example.demo.mapper.ClassesMapper;
import com.example.demo.mapper.ScoreMapper;
import com.example.demo.mapper.StudentMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ScoreMapper scoreMapper;


    @Override
    public ClassesDTO findByCnumAndCname(String cnumber, String cname) {
        ClassesDTO classesDTO = new ClassesDTO();
        classesDTO.setClassesNumber(cnumber);
        classesDTO.setClassesName(cname);

        //计算语、数、英班级平均分
        Integer cid = classesMapper.findCidByCnumAndCname(cnumber, cname);
        List<Student> students = studentMapper.findStudentByCid(cid);
        double totalChinese=0;
        double totalMath=0;
        double totalEnglish=0;
        for(Student student:students){
            totalChinese += scoreMapper.findBySid(student.getId()).getChinese();
            totalMath += scoreMapper.findBySid(student.getId()).getMath();
            totalEnglish += scoreMapper.findBySid(student.getId()).getEnglish();
        }
        classesDTO.setAvgChinese(Math.round(totalChinese/students.size()));
        classesDTO.setAvgMath(Math.round(totalMath/students.size()));
        classesDTO.setAvgEnglish(Math.round(totalEnglish/students.size()));

        //总平均分
        classesDTO.setAvgTotal(classesDTO.getAvgChinese(),classesDTO.getAvgMath(),classesDTO.getAvgEnglish());

        return classesDTO;
    }

    @Override
    public List<Classes> findAllClasses() {
        return classesMapper.findAllCname();

    }
}
