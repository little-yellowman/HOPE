package com.meyou.ssss.domain;

import javax.annotation.Generated;
import java.sql.Timestamp;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table ss_task
 */
public class SsTask {

    private Timestamp deadline;
    private String precautions;
    private String type;

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.93+08:00", comments="Source field: ss_task.sst_ID")
    private Long sstId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.93+08:00", comments="Source field: ss_task.info")
    private String info;

    /**
     * Database Column Remarks:
     *   提交人数
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source field: ss_task.submitNum")
    private Integer submitnum;

    /**
     * Database Column Remarks:
     *   外键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source field: ss_task.moniterID_sst")
    private Long moniteridSst;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.93+08:00", comments="Source field: ss_task.sst_ID")
    public Long getSstId() {
        return sstId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.93+08:00", comments="Source field: ss_task.sst_ID")
    public void setSstId(Long sstId) {
        this.sstId = sstId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.93+08:00", comments="Source field: ss_task.info")
    public String getInfo() {
        return info;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.93+08:00", comments="Source field: ss_task.info")
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source field: ss_task.submitNum")
    public Integer getSubmitnum() {
        return submitnum;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source field: ss_task.submitNum")
    public void setSubmitnum(Integer submitnum) {
        this.submitnum = submitnum;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source field: ss_task.moniterID_sst")
    public Long getMoniteridSst() {
        return moniteridSst;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source field: ss_task.moniterID_sst")
    public void setMoniteridSst(Long moniteridSst) {
        this.moniteridSst = moniteridSst;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.931+08:00", comments="Source Table: ss_task")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sstId=").append(sstId);
        sb.append(", info=").append(info);
        sb.append(", submitnum=").append(submitnum);
        sb.append(", moniteridSst=").append(moniteridSst);
        sb.append(", deadline=").append(deadline);
        sb.append(", precautions=").append(precautions);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}