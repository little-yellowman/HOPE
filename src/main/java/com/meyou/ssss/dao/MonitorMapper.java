package com.meyou.ssss.dao;

import com.meyou.ssss.domain.Monitor;
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

import static com.meyou.ssss.dao.MonitorDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Mapper
public interface MonitorMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    BasicColumn[] selectList = BasicColumn.columnList(mntId, mntName);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Monitor> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Monitor> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MonitorResult")
    Optional<Monitor> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MonitorResult", value = {
        @Result(column="mnt_id", property="mntId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mnt_name", property="mntName", jdbcType=JdbcType.VARCHAR)
    })
    List<Monitor> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, monitor, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.925+08:00", comments="Source Table: monitor")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, monitor, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    default int deleteByPrimaryKey(Long mntId_) {
        return delete(c -> 
            c.where(mntId, isEqualTo(mntId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    default int insert(Monitor record) {
        return MyBatis3Utils.insert(this::insert, record, monitor, c ->
            c.map(mntId).toProperty("mntId")
            .map(mntName).toProperty("mntName")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    default int insertMultiple(Collection<Monitor> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, monitor, c ->
            c.map(mntId).toProperty("mntId")
            .map(mntName).toProperty("mntName")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    default int insertSelective(Monitor record) {
        return MyBatis3Utils.insert(this::insert, record, monitor, c ->
            c.map(mntId).toPropertyWhenPresent("mntId", record::getMntId)
            .map(mntName).toPropertyWhenPresent("mntName", record::getMntName)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    default Optional<Monitor> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, monitor, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    default List<Monitor> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, monitor, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    default List<Monitor> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, monitor, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    default Optional<Monitor> selectByPrimaryKey(Long mntId_) {
        return selectOne(c ->
            c.where(mntId, isEqualTo(mntId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, monitor, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    static UpdateDSL<UpdateModel> updateAllColumns(Monitor record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(mntId).equalTo(record::getMntId)
                .set(mntName).equalTo(record::getMntName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Monitor record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(mntId).equalToWhenPresent(record::getMntId)
                .set(mntName).equalToWhenPresent(record::getMntName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.926+08:00", comments="Source Table: monitor")
    default int updateByPrimaryKey(Monitor record) {
        return update(c ->
            c.set(mntName).equalTo(record::getMntName)
            .where(mntId, isEqualTo(record::getMntId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.927+08:00", comments="Source Table: monitor")
    default int updateByPrimaryKeySelective(Monitor record) {
        return update(c ->
            c.set(mntName).equalToWhenPresent(record::getMntName)
            .where(mntId, isEqualTo(record::getMntId))
        );
    }
}