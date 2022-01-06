package com.example.demo.Service.Impl;

import com.example.demo.Service.ScoreService;
import com.example.demo.domain.Student;
import com.example.demo.dto.ScoreDTO;
import com.example.demo.form.Condition;
import com.example.demo.mapper.ClassesMapper;
import com.example.demo.mapper.ScoreMapper;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ScoreMapper scoreMapper;


    @Override
    public List<ScoreDTO> findByCondition(Condition condition) {
       // return scoreMapper.findByCondition(condition);
        List<ScoreDTO> scoreDTOList = new ArrayList<>();
        String className = condition.getClassesName();
        String studentName= condition.getStudentName();
        Integer avgMin = condition.getAvgMin();
        Integer avgMax = condition.getAvgMax();

       /* if(className!=null && studentName==null && avgMin==null && avgMax==null) {
            Integer cid = classesMapper.findCidByCname(className);
            List<Student> students = studentMapper.findStudentByCid(cid);
            for (Student student : students) {
                ScoreDTO scoreDTO = new ScoreDTO();
                scoreDTO.setStudentName(student.getName());
                scoreDTO.setClassesName(className);
                scoreDTO.setChinese(scoreMapper.findBySid(student.getId()).getChinese());
                scoreDTO.setMath(scoreMapper.findBySid(student.getId()).getMath());
                scoreDTO.setEnglish(scoreMapper.findBySid(student.getId()).getEnglish());
                scoreDTO.setScore((scoreMapper.findBySid(student.getId()).getChinese() + scoreMapper.findBySid(student.getId()).getMath() + scoreMapper.findBySid(student.getId()).getEnglish()) / 3);
                scoreDTOList.add(scoreDTO);

            }
            return scoreDTOList;
        }*/

        if((className!=null || className=="请选择") && studentName!=null && avgMin==null && avgMax==null) {
            ScoreDTO scoreDTO = new ScoreDTO();
            Integer sid = studentMapper.findSidBySname(studentName);
            scoreDTO.setClassesName(classesMapper.findCnameByCid(studentMapper.findCidBySid(sid)));
            scoreDTO.setStudentName(studentName);
            scoreDTO.setChinese(scoreMapper.findBySid(sid).getChinese());
            scoreDTO.setMath(scoreMapper.findBySid(sid).getMath());
            scoreDTO.setEnglish(scoreMapper.findBySid(sid).getEnglish());
            scoreDTO.setScore((scoreMapper.findBySid(sid).getChinese()+scoreMapper.findBySid(sid).getMath()+scoreMapper.findBySid(sid).getEnglish())/3);
            scoreDTOList.add(scoreDTO);
            return scoreDTOList;
        }


      /*  if(className!=null && studentName!=null && avgMin!=null && avgMax!=null) {
            Integer sid = studentMapper.findSidBySname(condition.getStudentName());
            Integer score = (scoreMapper.findBySid(sid).getChinese() + scoreMapper.findBySid(sid).getMath() + scoreMapper.findBySid(sid).getEnglish()) / 3;
            if (score >= condition.getAvgMin() && score <= condition.getAvgMax()) {
                ScoreDTO scoreDTO = new ScoreDTO();
                scoreDTO.setClassesName(className);
                scoreDTO.setStudentName(studentName);
                scoreDTO.setChinese(scoreMapper.findBySid(sid).getChinese());
                scoreDTO.setMath(scoreMapper.findBySid(sid).getMath());
                scoreDTO.setEnglish(scoreMapper.findBySid(sid).getEnglish());
                scoreDTO.setScore(score);
                scoreDTOList.add(scoreDTO);
                return scoreDTOList;
            } else {
                return null;
            }
        }*/

        if(avgMin!=null && avgMax!=null) {
            List<Student> students = studentMapper.findAll();
            for (Student student : students) {
                Integer score=(scoreMapper.findBySid(student.getId()).getChinese() + scoreMapper.findBySid(student.getId()).getMath() + scoreMapper.findBySid(student.getId()).getEnglish()) / 3;
                if(score >= condition.getAvgMin() && score <= condition.getAvgMax()) {
                    ScoreDTO scoreDTO = new ScoreDTO();
                    scoreDTO.setStudentName(student.getName());
                    scoreDTO.setClassesName(classesMapper.findCnameByCid(student.getClasses().getId()));
                    scoreDTO.setChinese(scoreMapper.findBySid(student.getId()).getChinese());
                    scoreDTO.setMath(scoreMapper.findBySid(student.getId()).getMath());
                    scoreDTO.setEnglish(scoreMapper.findBySid(student.getId()).getEnglish());
                    scoreDTO.setScore(score);
                    scoreDTOList.add(scoreDTO);
                }
            }
            return scoreDTOList;
        }

        return null;
    }

    @Override
    public List<Student> findSnameByCname(Integer cid) {
        return studentMapper.findStudentByCid(cid);

    }
}
