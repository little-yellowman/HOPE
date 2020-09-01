package com.meyou.ssss.dao;

import com.meyou.ssss.domain.Banjiclass;
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

import static com.meyou.ssss.dao.BanjiclassDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface BanjiclassMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    BasicColumn[] selectList = BasicColumn.columnList(classId, className, classAmount, majoridClass, monitoridClass);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Banjiclass> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Banjiclass> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BanjiclassResult")
    Optional<Banjiclass> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BanjiclassResult", value = {
        @Result(column="class_id", property="classId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="class_name", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_amount", property="classAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="majorID_class", property="majoridClass", jdbcType=JdbcType.INTEGER),
        @Result(column="monitorID_class", property="monitoridClass", jdbcType=JdbcType.BIGINT)
    })
    List<Banjiclass> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, banjiclass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, banjiclass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    default int deleteByPrimaryKey(Long classId_) {
        return delete(c -> 
            c.where(classId, isEqualTo(classId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.939+08:00", comments="Source Table: banjiClass")
    default int insert(Banjiclass record) {
        return MyBatis3Utils.insert(this::insert, record, banjiclass, c ->
            c.map(classId).toProperty("classId")
            .map(className).toProperty("className")
            .map(classAmount).toProperty("classAmount")
            .map(majoridClass).toProperty("majoridClass")
            .map(monitoridClass).toProperty("monitoridClass")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    default int insertMultiple(Collection<Banjiclass> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, banjiclass, c ->
            c.map(classId).toProperty("classId")
            .map(className).toProperty("className")
            .map(classAmount).toProperty("classAmount")
            .map(majoridClass).toProperty("majoridClass")
            .map(monitoridClass).toProperty("monitoridClass")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    default int insertSelective(Banjiclass record) {
        return MyBatis3Utils.insert(this::insert, record, banjiclass, c ->
            c.map(classId).toPropertyWhenPresent("classId", record::getClassId)
            .map(className).toPropertyWhenPresent("className", record::getClassName)
            .map(classAmount).toPropertyWhenPresent("classAmount", record::getClassAmount)
            .map(majoridClass).toPropertyWhenPresent("majoridClass", record::getMajoridClass)
            .map(monitoridClass).toPropertyWhenPresent("monitoridClass", record::getMonitoridClass)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    default Optional<Banjiclass> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, banjiclass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    default List<Banjiclass> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, banjiclass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    default List<Banjiclass> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, banjiclass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    default Optional<Banjiclass> selectByPrimaryKey(Long classId_) {
        return selectOne(c ->
            c.where(classId, isEqualTo(classId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, banjiclass, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    static UpdateDSL<UpdateModel> updateAllColumns(Banjiclass record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(classId).equalTo(record::getClassId)
                .set(className).equalTo(record::getClassName)
                .set(classAmount).equalTo(record::getClassAmount)
                .set(majoridClass).equalTo(record::getMajoridClass)
                .set(monitoridClass).equalTo(record::getMonitoridClass);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Banjiclass record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(classId).equalToWhenPresent(record::getClassId)
                .set(className).equalToWhenPresent(record::getClassName)
                .set(classAmount).equalToWhenPresent(record::getClassAmount)
                .set(majoridClass).equalToWhenPresent(record::getMajoridClass)
                .set(monitoridClass).equalToWhenPresent(record::getMonitoridClass);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    default int updateByPrimaryKey(Banjiclass record) {
        return update(c ->
            c.set(className).equalTo(record::getClassName)
            .set(classAmount).equalTo(record::getClassAmount)
            .set(majoridClass).equalTo(record::getMajoridClass)
            .set(monitoridClass).equalTo(record::getMonitoridClass)
            .where(classId, isEqualTo(record::getClassId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.94+08:00", comments="Source Table: banjiClass")
    default int updateByPrimaryKeySelective(Banjiclass record) {
        return update(c ->
            c.set(className).equalToWhenPresent(record::getClassName)
            .set(classAmount).equalToWhenPresent(record::getClassAmount)
            .set(majoridClass).equalToWhenPresent(record::getMajoridClass)
            .set(monitoridClass).equalToWhenPresent(record::getMonitoridClass)
            .where(classId, isEqualTo(record::getClassId))
        );
    }

    //班级和班长的join连接查询
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("joinBanjiAndMonitorResult")
    Optional<Banjiclass> selectOneJoinWithMon(SelectStatementProvider selectStatement);
}