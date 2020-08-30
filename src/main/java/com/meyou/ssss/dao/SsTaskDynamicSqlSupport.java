package com.meyou.ssss.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;
import java.sql.Timestamp;

public final class SsTaskDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source Table: ss_task")
    public static final SsTask ssTask = new SsTask();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source field: ss_task.sst_ID")
    public static final SqlColumn<Long> sstId = ssTask.sstId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source field: ss_task.info")
    public static final SqlColumn<String> info = ssTask.info;

    /**
     * Database Column Remarks:
     *   提交人数
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source field: ss_task.submitNum")
    public static final SqlColumn<Integer> submitnum = ssTask.submitnum;

    /**
     * Database Column Remarks:
     *   外键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source field: ss_task.moniterID_sst")
    public static final SqlColumn<Long> moniteridSst = ssTask.moniteridSst;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source Table: ss_task")
    public static final SqlColumn<Timestamp> deadline = ssTask.deadline;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source Table: ss_task")
    public static final SqlColumn<String> type = ssTask.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source Table: ss_task")
    public static final SqlColumn<String> precautions = ssTask.precautions;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source Table: ss_task")
    public static final class SsTask extends SqlTable {
        public final SqlColumn<Long> sstId = column("sst_ID", JDBCType.BIGINT);

        public final SqlColumn<String> info = column("info", JDBCType.VARCHAR);

        public final SqlColumn<Integer> submitnum = column("submitNum", JDBCType.INTEGER);

        public final SqlColumn<Long> moniteridSst = column("moniterID_sst", JDBCType.BIGINT);

        public final SqlColumn<Timestamp> deadline = column("deadline",JDBCType.TIMESTAMP);

        public final SqlColumn<String> type = column("type", JDBCType.VARCHAR);

        public final SqlColumn<String> precautions = column("precautions", JDBCType.VARCHAR);

        public SsTask() {
            super("ss_task");
        }
    }
}