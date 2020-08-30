package com.meyou.ssss;

import com.meyou.ssss.dao.BanjiclassMapper;
import com.meyou.ssss.dao.MonitorMapper;
import com.meyou.ssss.dao.StudentMapper;
import com.meyou.ssss.dao.sqlImpl.StudentSqlImpl;
import com.meyou.ssss.domain.Banjiclass;
import com.meyou.ssss.domain.Monitor;
import com.meyou.ssss.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest
public class studentTest {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private MonitorMapper monitorMapper;
    @Autowired
    private StudentSqlImpl studentSql;
    @Autowired
    private BanjiclassMapper banjiclassMapper;

    //
    @Test
    void findAll2(){
        List<Student> students = studentMapper.selectMany(studentSql.findAll2());
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //
    @Test
    void findAll(){
        List<Student> students = studentMapper.select(studentSql.findAll());
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //多表联查
    @Test
    void findClassStudents(){
        List<Student> studentList = studentMapper.selectManyJoin(studentSql.findClassStudents2(201713453131L));
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    //多表联查
    @Test
    void findClassStudents2(){
        Optional<Monitor> monitor = monitorMapper.selectOne(studentSql.findClassStudents2(201713453131L));
        System.out.println(monitor.get());
    }

    @Test
    void findOne(){
        Optional<Student> student = studentMapper.selectByPrimaryKey(201713453131l);
        System.out.println(student.isPresent());
        System.out.println(student.get());
    }

    //班级查询测试
    @Test
    void findClass(){
        List<Banjiclass> list = banjiclassMapper.select(c->c);
                // c.where(majoridClass, isEqualTo(10102)));
        for (Banjiclass banjiclass : list) {
            System.out.println(banjiclass);
        }
    }

    @Test
    void test(){
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

        System.out.println(timestamp.getTime());
    }
}
