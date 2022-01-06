package com.example.demo.mapper;

import com.example.demo.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    Student findSidBySnumAndSname(@Param("number") String snumber, @Param("name") String sname);//找出sid (student)
    List<Student> findStudentByCid(@Param("id") Integer cid);//根据cid查一个班有哪些学生 (student)
    Integer findSidBySname(@Param("name") String sname);//sid (student)
    List<Student> findAll();
    Integer findCidBySid(@Param("id") Integer sid);
    String findMax();
    int save(Student student);
}
