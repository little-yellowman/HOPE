package com.meyou.ssss.dao;

import com.meyou.ssss.domain.Student;
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

import static com.meyou.ssss.dao.StudentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface StudentMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    BasicColumn[] selectList = BasicColumn.columnList(stuId, stuName, stuPassword, grade, monitoridStu, collegenameStu, majornameStu);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source Table: student")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source Table: student")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Student> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source Table: student")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Student> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("StudentResult")
    Optional<Student> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="StudentResult", value = {
        @Result(column="stu_id", property="stuId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="stu_name", property="stuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="stu_password", property="stuPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.INTEGER),
        @Result(column="monitorID_stu", property="monitoridStu", jdbcType=JdbcType.BIGINT),
        @Result(column="collegeName_stu", property="collegenameStu", jdbcType=JdbcType.VARCHAR),
        @Result(column="majorName_stu", property="majornameStu", jdbcType=JdbcType.VARCHAR)
    })
    List<Student> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source Table: student")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source Table: student")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.936+08:00", comments="Source Table: student")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default int deleteByPrimaryKey(Long stuId_) {
        return delete(c -> 
            c.where(stuId, isEqualTo(stuId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default int insert(Student record) {
        return MyBatis3Utils.insert(this::insert, record, student, c ->
            c.map(stuId).toProperty("stuId")
            .map(stuName).toProperty("stuName")
            .map(stuPassword).toProperty("stuPassword")
            .map(grade).toProperty("grade")
            .map(monitoridStu).toProperty("monitoridStu")
            .map(collegenameStu).toProperty("collegenameStu")
            .map(majornameStu).toProperty("majornameStu")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default int insertMultiple(Collection<Student> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, student, c ->
            c.map(stuId).toProperty("stuId")
            .map(stuName).toProperty("stuName")
            .map(stuPassword).toProperty("stuPassword")
            .map(grade).toProperty("grade")
            .map(monitoridStu).toProperty("monitoridStu")
            .map(collegenameStu).toProperty("collegenameStu")
            .map(majornameStu).toProperty("majornameStu")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default int insertSelective(Student record) {
        return MyBatis3Utils.insert(this::insert, record, student, c ->
            c.map(stuId).toPropertyWhenPresent("stuId", record::getStuId)
            .map(stuName).toPropertyWhenPresent("stuName", record::getStuName)
            .map(stuPassword).toPropertyWhenPresent("stuPassword", record::getStuPassword)
            .map(grade).toPropertyWhenPresent("grade", record::getGrade)
            .map(monitoridStu).toPropertyWhenPresent("monitoridStu", record::getMonitoridStu)
            .map(collegenameStu).toPropertyWhenPresent("collegenameStu", record::getCollegenameStu)
            .map(majornameStu).toPropertyWhenPresent("majornameStu", record::getMajornameStu)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default Optional<Student> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default List<Student> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default List<Student> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default Optional<Student> selectByPrimaryKey(Long stuId_) {
        return selectOne(c ->
            c.where(stuId, isEqualTo(stuId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    static UpdateDSL<UpdateModel> updateAllColumns(Student record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(stuId).equalTo(record::getStuId)
                .set(stuName).equalTo(record::getStuName)
                .set(stuPassword).equalTo(record::getStuPassword)
                .set(grade).equalTo(record::getGrade)
                .set(monitoridStu).equalTo(record::getMonitoridStu)
                .set(collegenameStu).equalTo(record::getCollegenameStu)
                .set(majornameStu).equalTo(record::getMajornameStu);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Student record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(stuId).equalToWhenPresent(record::getStuId)
                .set(stuName).equalToWhenPresent(record::getStuName)
                .set(stuPassword).equalToWhenPresent(record::getStuPassword)
                .set(grade).equalToWhenPresent(record::getGrade)
                .set(monitoridStu).equalToWhenPresent(record::getMonitoridStu)
                .set(collegenameStu).equalToWhenPresent(record::getCollegenameStu)
                .set(majornameStu).equalToWhenPresent(record::getMajornameStu);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default int updateByPrimaryKey(Student record) {
        return update(c ->
            c.set(stuName).equalTo(record::getStuName)
            .set(stuPassword).equalTo(record::getStuPassword)
            .set(grade).equalTo(record::getGrade)
            .set(monitoridStu).equalTo(record::getMonitoridStu)
            .set(collegenameStu).equalTo(record::getCollegenameStu)
            .set(majornameStu).equalTo(record::getMajornameStu)
            .where(stuId, isEqualTo(record::getStuId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-01T16:22:07.937+08:00", comments="Source Table: student")
    default int updateByPrimaryKeySelective(Student record) {
        return update(c ->
            c.set(stuName).equalToWhenPresent(record::getStuName)
            .set(stuPassword).equalToWhenPresent(record::getStuPassword)
            .set(grade).equalToWhenPresent(record::getGrade)
            .set(monitoridStu).equalToWhenPresent(record::getMonitoridStu)
            .set(collegenameStu).equalToWhenPresent(record::getCollegenameStu)
            .set(majornameStu).equalToWhenPresent(record::getMajornameStu)
            .where(stuId, isEqualTo(record::getStuId))
        );
    }

    // 自定义,多表联查
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("joinStudentInfoResult")
    Optional<Student> selectOneJoin(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-30T08:31:39.526+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("joinStudentInfoResult")
    List<Student> selectManyJoin(SelectStatementProvider selectStatement);

    //学生和截图的多表join连接查询
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("joinScreenshotInfoResult")
    Optional<Student> selectOneJoinWithScrn(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-30T08:31:39.526+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("joinScreenshotInfoResult")
    List<Student> selectManyJoinWithScrn(SelectStatementProvider selectStatement);


}