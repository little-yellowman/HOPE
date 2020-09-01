package com.meyou.ssss.dao;

import com.meyou.ssss.domain.SsTask;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.meyou.ssss.dao.SsTaskDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SsTaskMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.933+08:00", comments="Source Table: ss_task")
    BasicColumn[] selectList = BasicColumn.columnList(sstId, info, submitnum, moniteridSst,deadline, type, precautions);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SsTask> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SsTask> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SsTaskResult")
    Optional<SsTask> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SsTaskResult", value = {
        @Result(column="sst_ID", property="sstId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="submitNum", property="submitnum", jdbcType=JdbcType.INTEGER),
        @Result(column="moniterID_sst", property="moniteridSst", jdbcType=JdbcType.BIGINT)
    })
    List<SsTask> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ssTask, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ssTask, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    default int deleteByPrimaryKey(Long sstId_) {
        return delete(c -> 
            c.where(sstId, isEqualTo(sstId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    default int insert(SsTask record) {
        return MyBatis3Utils.insert(this::insert, record, ssTask, c ->
            c.map(sstId).toProperty("sstId")
            .map(info).toProperty("info")
            .map(submitnum).toProperty("submitnum")
            .map(moniteridSst).toProperty("moniteridSst")
            .map(deadline).toProperty("deadline")
            .map(type).toProperty("type")
            .map(precautions).toProperty("precautions")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.932+08:00", comments="Source Table: ss_task")
    default int insertMultiple(Collection<SsTask> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ssTask, c ->
                c.map(sstId).toProperty("sstId")
                        .map(info).toProperty("info")
                        .map(submitnum).toProperty("submitnum")
                        .map(moniteridSst).toProperty("moniteridSst")
                        .map(deadline).toProperty("deadline")
                        .map(type).toProperty("type")
                        .map(precautions).toProperty("precautions")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.933+08:00", comments="Source Table: ss_task")
    default int insertSelective(SsTask record) {
        return MyBatis3Utils.insert(this::insert, record, ssTask, c ->
            c.map(sstId).toPropertyWhenPresent("sstId", record::getSstId)
            .map(info).toPropertyWhenPresent("info", record::getInfo)
            .map(submitnum).toPropertyWhenPresent("submitnum", record::getSubmitnum)
            .map(moniteridSst).toPropertyWhenPresent("moniteridSst", record::getMoniteridSst)
                    .map(deadline).toPropertyWhenPresent("deadline", record::getDeadline)
                    .map(type).toPropertyWhenPresent("type", record::getType)
                    .map(precautions).toPropertyWhenPresent("precautions",record::getPrecautions)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.933+08:00", comments="Source Table: ss_task")
    default Optional<SsTask> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ssTask, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.933+08:00", comments="Source Table: ss_task")
    default List<SsTask> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ssTask, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.933+08:00", comments="Source Table: ss_task")
    default List<SsTask> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ssTask, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.933+08:00", comments="Source Table: ss_task")
    default Optional<SsTask> selectByPrimaryKey(Long sstId_) {
        return selectOne(c ->
            c.where(sstId, isEqualTo(sstId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.933+08:00", comments="Source Table: ss_task")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ssTask, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.933+08:00", comments="Source Table: ss_task")
    static UpdateDSL<UpdateModel> updateAllColumns(SsTask record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(sstId).equalTo(record::getSstId)
                .set(info).equalTo(record::getInfo)
                .set(submitnum).equalTo(record::getSubmitnum)
                .set(moniteridSst).equalTo(record::getMoniteridSst)
                .set(deadline).equalTo(record::getDeadline)
                .set(type).equalTo(record::getType)
                .set(precautions).equalTo(record::getPrecautions);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.933+08:00", comments="Source Table: ss_task")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SsTask record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(sstId).equalToWhenPresent(record::getSstId)
                .set(info).equalToWhenPresent(record::getInfo)
                .set(submitnum).equalToWhenPresent(record::getSubmitnum)
                .set(moniteridSst).equalToWhenPresent(record::getMoniteridSst)
                .set(deadline).equalToWhenPresent(record::getDeadline)
                .set(type).equalToWhenPresent(record::getType)
                .set(precautions).equalToWhenPresent(record::getPrecautions);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.934+08:00", comments="Source Table: ss_task")
    default int updateByPrimaryKey(SsTask record) {
        return update(c ->
            c.set(info).equalTo(record::getInfo)
            .set(submitnum).equalTo(record::getSubmitnum)
            .set(moniteridSst).equalTo(record::getMoniteridSst)
                    .set(deadline).equalTo(record::getDeadline)
                    .set(type).equalTo(record::getType)
                    .set(precautions).equalTo(record::getPrecautions)
            .where(sstId, isEqualTo(record::getSstId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.934+08:00", comments="Source Table: ss_task")
    default int updateByPrimaryKeySelective(SsTask record) {
        return update(c ->
            c.set(info).equalToWhenPresent(record::getInfo)
            .set(submitnum).equalToWhenPresent(record::getSubmitnum)
            .set(moniteridSst).equalToWhenPresent(record::getMoniteridSst)
                    .set(deadline).equalToWhenPresent(record::getDeadline)
                    .set(type).equalToWhenPresent(record::getType)
                    .set(precautions).equalToWhenPresent(record::getPrecautions)
            .where(sstId, isEqualTo(record::getSstId))
        );
    }
}