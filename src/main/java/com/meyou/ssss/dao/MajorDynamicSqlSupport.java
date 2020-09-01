package com.meyou.ssss.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MajorDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.922+08:00", comments="Source Table: major")
    public static final Major major = new Major();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.922+08:00", comments="Source field: major.majorCode")
    public static final SqlColumn<Integer> majorcode = major.majorcode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.922+08:00", comments="Source field: major.mjr_name")
    public static final SqlColumn<String> mjrName = major.mjrName;

    /**
     * Database Column Remarks:
     *   外键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source field: major.collegeName_mjr")
    public static final SqlColumn<String> collegenameMjr = major.collegenameMjr;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.922+08:00", comments="Source Table: major")
    public static final class Major extends SqlTable {
        public final SqlColumn<Integer> majorcode = column("majorCode", JDBCType.INTEGER);

        public final SqlColumn<String> mjrName = column("mjr_name", JDBCType.VARCHAR);

        public final SqlColumn<String> collegenameMjr = column("collegeName_mjr", JDBCType.VARCHAR);

        public Major() {
            super("major");
        }
    }
}