package com.example.demo.Service.Impl;

import com.example.demo.Service.StudentService;
import com.example.demo.domain.Student;
import com.example.demo.dto.StudentDTO;
import com.example.demo.mapper.ClassesMapper;
import com.example.demo.mapper.ScoreMapper;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private ScoreMapper scoreMapper;


    @Override
    public StudentDTO findByNumAndName(String number, String name) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentNum(number);
        studentDTO.setStudentName(name);
        //班级名称
        Integer cid = studentMapper.findSidBySnumAndSname(number, name).getClasses().getId();
        String className = classesMapper.findCnameByCid(cid);
        studentDTO.setClassName(className);
        //地址
        String address = studentMapper.findSidBySnumAndSname(number, name).getAddress();
        studentDTO.setAddress(address);
        //年龄
        LocalDate birthday = studentMapper.findSidBySnumAndSname(number, name).getBirthday();
        studentDTO.setAge(birthday);
        //根据学生s_id查成绩
        Integer sid = studentMapper.findSidBySnumAndSname(number, name).getId();
        studentDTO.setChinese(scoreMapper.findBySid(sid).getChinese());
        studentDTO.setMath(scoreMapper.findBySid(sid).getMath());
        studentDTO.setEnglish(scoreMapper.findBySid(sid).getEnglish());
        //计算总成绩、平均分
        studentDTO.setTotal(scoreMapper.findBySid(sid).getChinese(),scoreMapper.findBySid(sid).getMath(),scoreMapper.findBySid(sid).getEnglish());
        studentDTO.setAvg(studentDTO.getTotal());

        return studentDTO;
    }

    @Override
    public int generateSnumber() {
        Student student = new Student();
        String max = studentMapper.findMax();
        int count = Integer.parseInt(max.substring(8, 13));
        String code = new DecimalFormat("00000").format(count + 1);
        String date = new SimpleDateFormat("yyyyMM").format(new Date());
        student.setNumber("SN" + date + code);
        return studentMapper.save(student);
    }


}
