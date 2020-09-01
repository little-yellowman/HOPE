package com.meyou.ssss.service;

import com.meyou.ssss.dao.ScreenshotsMapper;
import com.meyou.ssss.domain.Screenshots;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.meyou.ssss.dao.ScreenshotsDynamicSqlSupport.*;
import static com.meyou.ssss.dao.StudentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class ScreenshotService {
    private ScreenshotsMapper screenshotsMapper;

    @Autowired
    public ScreenshotService(ScreenshotsMapper screenshotsMapper) {
        this.screenshotsMapper = screenshotsMapper;
    }

    //保存截图
    public int saveScreenShot(Screenshots scrn){
        int insert = screenshotsMapper.insert(scrn);
        return insert;
    }

    /*
    *@Description:删除截图
    *@Author:yuan yulin
    *@Param: screenshot 的id
    */
    public int delScreenshot(String scnId){

        return screenshotsMapper.deleteByPrimaryKey(scnId);
    }


    //根据学生id和截图任务id精确查找提交的截图
    public Optional<Screenshots> findOne(Long stuId, Long taskId){
        Optional<Screenshots> screenshots = screenshotsMapper.selectOne(c ->
                c.where(studentidScrnsht, isEqualTo(stuId))
                        .and(taskidScrnsht, isEqualTo(taskId))
        );
        return screenshots;
    }

    //查询截图的完整信息，班长查看，和student表join
    public List<Screenshots> findAll(Long taskId, Long monitorId){

        SelectStatementProvider findAll = select(scrnshtId,stuId, stuName,studentidScrnsht, submitted,path)
                .from(screenshots)
                .rightJoin(student)
                .on(stuId, equalTo(studentidScrnsht))
                .where(taskidScrnsht,isEqualTo(taskId))
                .and(monitoridStu, isEqualTo(monitorId))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return screenshotsMapper.selectManyJoin(findAll);
    }

    //查询所有的截图
    public List<Screenshots> findAll(Long taskId){

        return screenshotsMapper.select(c->
                c.where(taskidScrnsht,isEqualTo(taskId))
        );
    }
}
