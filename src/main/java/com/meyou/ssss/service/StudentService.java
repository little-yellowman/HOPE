package com.meyou.ssss.service;

import com.meyou.ssss.dao.StudentMapper;
import com.meyou.ssss.domain.Student;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.meyou.ssss.dao.ScreenshotsDynamicSqlSupport.*;
import static com.meyou.ssss.dao.StudentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class StudentService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private StudentMapper studentMapper;

    //根据主键查询一个学生
    public Optional<Student> selectOneById(Long sid){

        return studentMapper.selectByPrimaryKey(sid);
    }

    //保存一个学生
    public int insertOne(Student form){

        return studentMapper.insert(form);
    }

    //查询截图的完整信心，班长查看
    public List<Student> findAll(Long taskId, Long monitorId){

        SelectStatementProvider findAll = select(scrnshtId,stuId, stuName, submitted)
                .from(student)
                .leftJoin(screenshots)
                .on(stuId, equalTo(studentidScrnsht))
                .where(taskidScrnsht,isEqualTo(taskId))
                .and(monitoridStu, isEqualTo(monitorId))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return studentMapper.selectManyJoinWithScrn(findAll);
    }
}
