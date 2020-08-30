package com.meyou.ssss.dao;

import com.meyou.ssss.domain.Screenshots;
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

import static com.meyou.ssss.dao.ScreenshotsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ScreenshotsMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    BasicColumn[] selectList = BasicColumn.columnList(scrnshtId, path, submitted, taskidScrnsht, studentidScrnsht);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source Table: screenshots")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source Table: screenshots")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source Table: screenshots")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Screenshots> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source Table: screenshots")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Screenshots> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source Table: screenshots")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ScreenshotsResult")
    Optional<Screenshots> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source Table: screenshots")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ScreenshotsResult", value = {
        @Result(column="scrnsht_ID", property="scrnshtId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="submitted", property="submitted", jdbcType=JdbcType.BIT),
        @Result(column="taskID_scrnsht", property="taskidScrnsht", jdbcType=JdbcType.BIGINT),
        @Result(column="studentID_scrnsht", property="studentidScrnsht", jdbcType=JdbcType.BIGINT)
    })
    List<Screenshots> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source Table: screenshots")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.928+08:00", comments="Source Table: screenshots")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, screenshots, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, screenshots, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    default int deleteByPrimaryKey(String scrnshtId_) {
        return delete(c -> 
            c.where(scrnshtId, isEqualTo(scrnshtId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    default int insert(Screenshots record) {
        return MyBatis3Utils.insert(this::insert, record, screenshots, c ->
            c.map(scrnshtId).toProperty("scrnshtId")
            .map(path).toProperty("path")
            .map(submitted).toProperty("submitted")
            .map(taskidScrnsht).toProperty("taskidScrnsht")
            .map(studentidScrnsht).toProperty("studentidScrnsht")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    default int insertMultiple(Collection<Screenshots> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, screenshots, c ->
            c.map(scrnshtId).toProperty("scrnshtId")
            .map(path).toProperty("path")
            .map(submitted).toProperty("submitted")
            .map(taskidScrnsht).toProperty("taskidScrnsht")
            .map(studentidScrnsht).toProperty("studentidScrnsht")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    default int insertSelective(Screenshots record) {
        return MyBatis3Utils.insert(this::insert, record, screenshots, c ->
            c.map(scrnshtId).toPropertyWhenPresent("scrnshtId", record::getScrnshtId)
            .map(path).toPropertyWhenPresent("path", record::getPath)
            .map(submitted).toPropertyWhenPresent("submitted", record::getSubmitted)
            .map(taskidScrnsht).toPropertyWhenPresent("taskidScrnsht", record::getTaskidScrnsht)
            .map(studentidScrnsht).toPropertyWhenPresent("studentidScrnsht", record::getStudentidScrnsht)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    default Optional<Screenshots> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, screenshots, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    default List<Screenshots> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, screenshots, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    default List<Screenshots> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, screenshots, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    default Optional<Screenshots> selectByPrimaryKey(String scrnshtId_) {
        return selectOne(c ->
            c.where(scrnshtId, isEqualTo(scrnshtId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, screenshots, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.929+08:00", comments="Source Table: screenshots")
    static UpdateDSL<UpdateModel> updateAllColumns(Screenshots record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(scrnshtId).equalTo(record::getScrnshtId)
                .set(path).equalTo(record::getPath)
                .set(submitted).equalTo(record::getSubmitted)
                .set(taskidScrnsht).equalTo(record::getTaskidScrnsht)
                .set(studentidScrnsht).equalTo(record::getStudentidScrnsht);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.93+08:00", comments="Source Table: screenshots")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Screenshots record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(scrnshtId).equalToWhenPresent(record::getScrnshtId)
                .set(path).equalToWhenPresent(record::getPath)
                .set(submitted).equalToWhenPresent(record::getSubmitted)
                .set(taskidScrnsht).equalToWhenPresent(record::getTaskidScrnsht)
                .set(studentidScrnsht).equalToWhenPresent(record::getStudentidScrnsht);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.93+08:00", comments="Source Table: screenshots")
    default int updateByPrimaryKey(Screenshots record) {
        return update(c ->
            c.set(path).equalTo(record::getPath)
            .set(submitted).equalTo(record::getSubmitted)
            .set(taskidScrnsht).equalTo(record::getTaskidScrnsht)
            .set(studentidScrnsht).equalTo(record::getStudentidScrnsht)
            .where(scrnshtId, isEqualTo(record::getScrnshtId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.93+08:00", comments="Source Table: screenshots")
    default int updateByPrimaryKeySelective(Screenshots record) {
        return update(c ->
            c.set(path).equalToWhenPresent(record::getPath)
            .set(submitted).equalToWhenPresent(record::getSubmitted)
            .set(taskidScrnsht).equalToWhenPresent(record::getTaskidScrnsht)
            .set(studentidScrnsht).equalToWhenPresent(record::getStudentidScrnsht)
            .where(scrnshtId, isEqualTo(record::getScrnshtId))
        );
    }

    // 自定义,多表联查
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("joinScreenshotInfoResult")
    Optional<Screenshots> selectOneJoin(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-30T08:31:39.526+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("joinScreenshotInfoResult")
    List<Screenshots> selectManyJoin(SelectStatementProvider selectStatement);
}