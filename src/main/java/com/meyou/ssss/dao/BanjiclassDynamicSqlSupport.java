package com.meyou.ssss.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BanjiclassDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.938+08:00", comments="Source Table: banjiClass")
    public static final Banjiclass banjiclass = new Banjiclass();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source field: banjiClass.class_id")
    public static final SqlColumn<Long> classId = banjiclass.classId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source field: banjiClass.class_name")
    public static final SqlColumn<String> className = banjiclass.className;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source field: banjiClass.class_amount")
    public static final SqlColumn<Integer> classAmount = banjiclass.classAmount;

    /**
     * Database Column Remarks:
     *   外键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source field: banjiClass.majorID_class")
    public static final SqlColumn<Integer> majoridClass = banjiclass.majoridClass;

    /**
     * Database Column Remarks:
     *   外键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source field: banjiClass.monitorID_class")
    public static final SqlColumn<Long> monitoridClass = banjiclass.monitoridClass;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.938+08:00", comments="Source Table: banjiClass")
    public static final class Banjiclass extends SqlTable {
        public final SqlColumn<Long> classId = column("class_id", JDBCType.BIGINT);

        public final SqlColumn<String> className = column("class_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> classAmount = column("class_amount", JDBCType.INTEGER);

        public final SqlColumn<Integer> majoridClass = column("majorID_class", JDBCType.INTEGER);

        public final SqlColumn<Long> monitoridClass = column("monitorID_class", JDBCType.BIGINT);

        public Banjiclass() {
            super("banjiClass");
        }
    }
}