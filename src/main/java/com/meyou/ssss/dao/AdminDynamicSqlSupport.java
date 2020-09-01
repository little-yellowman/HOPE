package com.meyou.ssss.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

public final class AdminDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.903+08:00", comments="Source Table: admin")
    public static final Admin admin = new Admin();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.904+08:00", comments="Source field: admin.number")
    public static final SqlColumn<Long> number = admin.number;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.904+08:00", comments="Source field: admin.admin_password")
    public static final SqlColumn<String> adminPassword = admin.adminPassword;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.904+08:00", comments="Source Table: admin")
    public static final class Admin extends SqlTable {
        public final SqlColumn<Long> number = column("number", JDBCType.BIGINT);

        public final SqlColumn<String> adminPassword = column("admin_password", JDBCType.VARCHAR);

        public Admin() {
            super("admin");
        }
    }
}