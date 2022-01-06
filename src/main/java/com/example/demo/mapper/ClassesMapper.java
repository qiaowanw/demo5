package com.example.demo.mapper;

import com.example.demo.domain.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassesMapper {
    Integer findCidByCnumAndCname(@Param("number") String cnumber, @Param("name") String cname);//找出cid (class)
    String findCnameByCid(@Param("id") Integer cid);
    Integer findCidByCname(@Param("name") String cname);//找出cid (class)
    List<Classes> findAllCname();
}
