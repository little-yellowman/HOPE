package com.meyou.ssss.dao;

import com.meyou.ssss.domain.Admin;
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

import static com.meyou.ssss.dao.AdminDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Mapper
public interface AdminMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.913+08:00", comments="Source Table: admin")
    BasicColumn[] selectList = BasicColumn.columnList(number, adminPassword);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.905+08:00", comments="Source Table: admin")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.906+08:00", comments="Source Table: admin")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.906+08:00", comments="Source Table: admin")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Admin> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.907+08:00", comments="Source Table: admin")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Admin> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.907+08:00", comments="Source Table: admin")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AdminResult")
    Optional<Admin> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.908+08:00", comments="Source Table: admin")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AdminResult", value = {
        @Result(column="number", property="number", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="admin_password", property="adminPassword", jdbcType=JdbcType.VARCHAR)
    })
    List<Admin> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.909+08:00", comments="Source Table: admin")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.909+08:00", comments="Source Table: admin")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.91+08:00", comments="Source Table: admin")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.91+08:00", comments="Source Table: admin")
    default int deleteByPrimaryKey(Long number_) {
        return delete(c -> 
            c.where(number, isEqualTo(number_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.91+08:00", comments="Source Table: admin")
    default int insert(Admin record) {
        return MyBatis3Utils.insert(this::insert, record, admin, c ->
            c.map(number).toProperty("number")
            .map(adminPassword).toProperty("adminPassword")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.911+08:00", comments="Source Table: admin")
    default int insertMultiple(Collection<Admin> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, admin, c ->
            c.map(number).toProperty("number")
            .map(adminPassword).toProperty("adminPassword")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.912+08:00", comments="Source Table: admin")
    default int insertSelective(Admin record) {
        return MyBatis3Utils.insert(this::insert, record, admin, c ->
            c.map(number).toPropertyWhenPresent("number", record::getNumber)
            .map(adminPassword).toPropertyWhenPresent("adminPassword", record::getAdminPassword)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.914+08:00", comments="Source Table: admin")
    default Optional<Admin> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.914+08:00", comments="Source Table: admin")
    default List<Admin> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.915+08:00", comments="Source Table: admin")
    default List<Admin> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.915+08:00", comments="Source Table: admin")
    default Optional<Admin> selectByPrimaryKey(Long number_) {
        return selectOne(c ->
            c.where(number, isEqualTo(number_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.915+08:00", comments="Source Table: admin")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.916+08:00", comments="Source Table: admin")
    static UpdateDSL<UpdateModel> updateAllColumns(Admin record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(number).equalTo(record::getNumber)
                .set(adminPassword).equalTo(record::getAdminPassword);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.916+08:00", comments="Source Table: admin")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Admin record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(number).equalToWhenPresent(record::getNumber)
                .set(adminPassword).equalToWhenPresent(record::getAdminPassword);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.917+08:00", comments="Source Table: admin")
    default int updateByPrimaryKey(Admin record) {
        return update(c ->
            c.set(adminPassword).equalTo(record::getAdminPassword)
            .where(number, isEqualTo(record::getNumber))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.917+08:00", comments="Source Table: admin")
    default int updateByPrimaryKeySelective(Admin record) {
        return update(c ->
            c.set(adminPassword).equalToWhenPresent(record::getAdminPassword)
            .where(number, isEqualTo(record::getNumber))
        );
    }
}