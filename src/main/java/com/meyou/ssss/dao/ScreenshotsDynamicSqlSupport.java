package com.meyou.ssss.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

public final class ScreenshotsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.927+08:00", comments="Source Table: screenshots")
    public static final Screenshots screenshots = new Screenshots();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source field: screenshots.scrnsht_ID")
    public static final SqlColumn<String> scrnshtId = screenshots.scrnshtId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source field: screenshots.path")
    public static final SqlColumn<String> path = screenshots.path;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source field: screenshots.submitted")
    public static final SqlColumn<Boolean> submitted = screenshots.submitted;

    /**
     * Database Column Remarks:
     *   外键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source field: screenshots.taskID_scrnsht")
    public static final SqlColumn<Long> taskidScrnsht = screenshots.taskidScrnsht;

    /**
     * Database Column Remarks:
     *   外键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source field: screenshots.studentID_scrnsht")
    public static final SqlColumn<Long> studentidScrnsht = screenshots.studentidScrnsht;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.927+08:00", comments="Source Table: screenshots")
    public static final class Screenshots extends SqlTable {
        public final SqlColumn<String> scrnshtId = column("scrnsht_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> path = column("path", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> submitted = column("submitted", JDBCType.BIT);

        public final SqlColumn<Long> taskidScrnsht = column("taskID_scrnsht", JDBCType.BIGINT);

        public final SqlColumn<Long> studentidScrnsht = column("studentID_scrnsht", JDBCType.BIGINT);

        public Screenshots() {
            super("screenshots");
        }
    }
}