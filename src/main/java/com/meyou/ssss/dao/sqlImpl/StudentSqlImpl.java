package com.meyou.ssss.dao.sqlImpl;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;

import static com.meyou.ssss.dao.CollegeDynamicSqlSupport.college;
import static com.meyou.ssss.dao.CollegeDynamicSqlSupport.collegeId;
import static com.meyou.ssss.dao.MonitorDynamicSqlSupport.*;
import static com.meyou.ssss.dao.StudentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public class StudentSqlImpl {

    //查询所有
    public SelectDSLCompleter findAll(){
        return c->c;
    }

    //查询所有
    public SelectStatementProvider findAll2(){
        SelectStatementProvider findAll = select(stuId.as("stu_id"),grade,stuName.as("stu_name"),
                majornameStu.as("majorname_stu"))
                .from(student)
                .join(college)
                .on(collegenameStu,equalTo(collegeId))
                .join(monitor)
                .on(monitoridStu,equalTo(mntId))

                .build()
                .render(RenderingStrategies.MYBATIS3);

        return findAll;
    }

    //多表联查，学生查询班长名字
    public SelectStatementProvider findClassStudents(Long sid){
        SelectStatementProvider findAll = select(stuId,stuName,monitor.allColumns())
                .from(student)
                .join(monitor)
                .on(monitoridStu,equalTo(mntId))
                .where(stuId,isEqualTo(sid))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return findAll;
    }

    //多表联查，学生查询班长名字
    public SelectStatementProvider findClassStudents2(Long sid){
        SelectStatementProvider findAll = select(mntId,mntName)
                .from(monitor)
                .where(mntId, isEqualTo(select(monitoridStu).from(student).where(stuId,isEqualTo(sid))))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return findAll;
    }
}
