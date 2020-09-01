package com.meyou.ssss.dao;

import static com.meyou.ssss.dao.CollegeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.meyou.ssss.domain.College;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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

@Mapper
public interface CollegeMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    BasicColumn[] selectList = BasicColumn.columnList(collegeId, collegeAmount);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<College> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<College> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CollegeResult")
    Optional<College> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CollegeResult", value = {
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="college_amount", property="collegeAmount", jdbcType=JdbcType.INTEGER)
    })
    List<College> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, college, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, college, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    default int deleteByPrimaryKey(String collegeId_) {
        return delete(c -> 
            c.where(collegeId, isEqualTo(collegeId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.92+08:00", comments="Source Table: college")
    default int insert(College record) {
        return MyBatis3Utils.insert(this::insert, record, college, c ->
            c.map(collegeId).toProperty("collegeId")
            .map(collegeAmount).toProperty("collegeAmount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    default int insertMultiple(Collection<College> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, college, c ->
            c.map(collegeId).toProperty("collegeId")
            .map(collegeAmount).toProperty("collegeAmount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    default int insertSelective(College record) {
        return MyBatis3Utils.insert(this::insert, record, college, c ->
            c.map(collegeId).toPropertyWhenPresent("collegeId", record::getCollegeId)
            .map(collegeAmount).toPropertyWhenPresent("collegeAmount", record::getCollegeAmount)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    default Optional<College> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, college, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    default List<College> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, college, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    default List<College> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, college, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    default Optional<College> selectByPrimaryKey(String collegeId_) {
        return selectOne(c ->
            c.where(collegeId, isEqualTo(collegeId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, college, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    static UpdateDSL<UpdateModel> updateAllColumns(College record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(collegeId).equalTo(record::getCollegeId)
                .set(collegeAmount).equalTo(record::getCollegeAmount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(College record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(collegeId).equalToWhenPresent(record::getCollegeId)
                .set(collegeAmount).equalToWhenPresent(record::getCollegeAmount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    default int updateByPrimaryKey(College record) {
        return update(c ->
            c.set(collegeAmount).equalTo(record::getCollegeAmount)
            .where(collegeId, isEqualTo(record::getCollegeId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.921+08:00", comments="Source Table: college")
    default int updateByPrimaryKeySelective(College record) {
        return update(c ->
            c.set(collegeAmount).equalToWhenPresent(record::getCollegeAmount)
            .where(collegeId, isEqualTo(record::getCollegeId))
        );
    }
}