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

    //根据学生id和截图任务id精确查找提交的截图
    public Optional<Screenshots> findOne(Long stuId, Long taskId){
        Optional<Screenshots> screenshots = screenshotsMapper.selectOne(c ->
                c.where(studentidScrnsht, isEqualTo(stuId))
                        .and(taskidScrnsht, isEqualTo(taskId))
        );
        return screenshots;
    }

    //查询截图的完整信心，班长查看
    public List<Screenshots> findAll(Long taskId, Long monitorId){

        SelectStatementProvider findAll = select(scrnshtId,stuId, stuName, submitted)
                .from(screenshots)
                .rightJoin(student)
                .on(stuId, equalTo(studentidScrnsht))
                .where(taskidScrnsht,isEqualTo(taskId))
                .and(monitoridStu, isEqualTo(monitorId))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return screenshotsMapper.selectManyJoin(findAll);
    }
}
