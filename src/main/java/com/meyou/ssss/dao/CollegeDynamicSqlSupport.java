package com.meyou.ssss.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

public final class CollegeDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    public static final College college = new College();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source field: college.college_id")
    public static final SqlColumn<String> collegeId = college.collegeId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source field: college.college_amount")
    public static final SqlColumn<Integer> collegeAmount = college.collegeAmount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    public static final class College extends SqlTable {
        public final SqlColumn<String> collegeId = column("college_id", JDBCType.VARCHAR);

        public final SqlColumn<Integer> collegeAmount = column("college_amount", JDBCType.INTEGER);

        public College() {
            super("college");
        }
    }
}