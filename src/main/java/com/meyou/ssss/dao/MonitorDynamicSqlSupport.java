package com.meyou.ssss.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MonitorDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    public static final Monitor monitor = new Monitor();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source field: monitor.mnt_id")
    public static final SqlColumn<Long> mntId = monitor.mntId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source field: monitor.mnt_name")
    public static final SqlColumn<String> mntName = monitor.mntName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    public static final class Monitor extends SqlTable {
        public final SqlColumn<Long> mntId = column("mnt_id", JDBCType.BIGINT);

        public final SqlColumn<String> mntName = column("mnt_name", JDBCType.VARCHAR);

        public Monitor() {
            super("monitor");
        }
    }
}