package com.meyou.ssss.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

public final class StudentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.935+08:00", comments="Source Table: student")
    public static final Student student = new Student();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source field: student.stu_id")
    public static final SqlColumn<Long> stuId = student.stuId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source field: student.stu_name")
    public static final SqlColumn<String> stuName = student.stuName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source field: student.stu_password")
    public static final SqlColumn<String> stuPassword = student.stuPassword;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source field: student.grade")
    public static final SqlColumn<Integer> grade = student.grade;

    /**
     * Database Column Remarks:
     *   外键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source field: student.monitorID_stu")
    public static final SqlColumn<Long> monitoridStu = student.monitoridStu;

    /**
     * Database Column Remarks:
     *   外键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source field: student.collegeName_stu")
    public static final SqlColumn<String> collegenameStu = student.collegenameStu;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source field: student.majorName_stu")
    public static final SqlColumn<String> majornameStu = student.majornameStu;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.935+08:00", comments="Source Table: student")
    public static final class Student extends SqlTable {
        public final SqlColumn<Long> stuId = column("stu_id", JDBCType.BIGINT);

        public final SqlColumn<String> stuName = column("stu_name", JDBCType.VARCHAR);

        public final SqlColumn<String> stuPassword = column("stu_password", JDBCType.VARCHAR);

        public final SqlColumn<Integer> grade = column("grade", JDBCType.INTEGER);

        public final SqlColumn<Long> monitoridStu = column("monitorID_stu", JDBCType.BIGINT);

        public final SqlColumn<String> collegenameStu = column("collegeName_stu", JDBCType.VARCHAR);

        public final SqlColumn<String> majornameStu = column("majorName_stu", JDBCType.VARCHAR);


        public Student() {
            super("student");
        }
    }
}