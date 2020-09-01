package com.meyou.ssss.dao;

import com.meyou.ssss.domain.Major;
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

import static com.meyou.ssss.dao.MajorDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface MajorMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    BasicColumn[] selectList = BasicColumn.columnList(majorcode, mjrName, collegenameMjr);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Major> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Major> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MajorResult")
    Optional<Major> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MajorResult", value = {
        @Result(column="majorCode", property="majorcode", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mjr_name", property="mjrName", jdbcType=JdbcType.VARCHAR),
        @Result(column="collegeName_mjr", property="collegenameMjr", jdbcType=JdbcType.VARCHAR)
    })
    List<Major> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, major, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, major, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    default int deleteByPrimaryKey(Integer majorcode_) {
        return delete(c -> 
            c.where(majorcode, isEqualTo(majorcode_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    default int insert(Major record) {
        return MyBatis3Utils.insert(this::insert, record, major, c ->
            c.map(majorcode).toProperty("majorcode")
            .map(mjrName).toProperty("mjrName")
            .map(collegenameMjr).toProperty("collegenameMjr")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    default int insertMultiple(Collection<Major> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, major, c ->
            c.map(majorcode).toProperty("majorcode")
            .map(mjrName).toProperty("mjrName")
            .map(collegenameMjr).toProperty("collegenameMjr")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.923+08:00", comments="Source Table: major")
    default int insertSelective(Major record) {
        return MyBatis3Utils.insert(this::insert, record, major, c ->
            c.map(majorcode).toPropertyWhenPresent("majorcode", record::getMajorcode)
            .map(mjrName).toPropertyWhenPresent("mjrName", record::getMjrName)
            .map(collegenameMjr).toPropertyWhenPresent("collegenameMjr", record::getCollegenameMjr)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.924+08:00", comments="Source Table: major")
    default Optional<Major> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, major, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.924+08:00", comments="Source Table: major")
    default List<Major> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, major, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.924+08:00", comments="Source Table: major")
    default List<Major> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, major, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.924+08:00", comments="Source Table: major")
    default Optional<Major> selectByPrimaryKey(Integer majorcode_) {
        return selectOne(c ->
            c.where(majorcode, isEqualTo(majorcode_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.924+08:00", comments="Source Table: major")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, major, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.924+08:00", comments="Source Table: major")
    static UpdateDSL<UpdateModel> updateAllColumns(Major record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(majorcode).equalTo(record::getMajorcode)
                .set(mjrName).equalTo(record::getMjrName)
                .set(collegenameMjr).equalTo(record::getCollegenameMjr);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.924+08:00", comments="Source Table: major")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Major record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(majorcode).equalToWhenPresent(record::getMajorcode)
                .set(mjrName).equalToWhenPresent(record::getMjrName)
                .set(collegenameMjr).equalToWhenPresent(record::getCollegenameMjr);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.924+08:00", comments="Source Table: major")
    default int updateByPrimaryKey(Major record) {
        return update(c ->
            c.set(mjrName).equalTo(record::getMjrName)
            .set(collegenameMjr).equalTo(record::getCollegenameMjr)
            .where(majorcode, isEqualTo(record::getMajorcode))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.924+08:00", comments="Source Table: major")
    default int updateByPrimaryKeySelective(Major record) {
        return update(c ->
            c.set(mjrName).equalToWhenPresent(record::getMjrName)
            .set(collegenameMjr).equalToWhenPresent(record::getCollegenameMjr)
            .where(majorcode, isEqualTo(record::getMajorcode))
        );
    }
}