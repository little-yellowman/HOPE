package com.meyou.ssss.service;

import com.meyou.ssss.dao.BanjiclassMapper;
import com.meyou.ssss.domain.Banjiclass;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.meyou.ssss.dao.BanjiclassDynamicSqlSupport.*;
import static com.meyou.ssss.dao.MonitorDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class BanjiClassService {

    private final BanjiclassMapper banji;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public BanjiClassService(BanjiclassMapper banji) {
        this.banji = banji;
    }

    public List<Banjiclass> findClass(String grade,Integer majorId){
        StringBuilder sb = new StringBuilder();
        sb.append("%").append(grade).append("%");
        return banji.select(c->
                c.where(majoridClass, isEqualTo(majorId))
                .and(className,isLike(sb.toString()))
        );
    }

    //通过班长id查找班级
    public Optional<Banjiclass> findByMonitorId(Long sid){
        SelectStatementProvider sql = select(classId,className)
                .from(banjiclass)
                .where(monitoridClass,isEqualTo(sid))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return banji.selectOne(sql);
    }

    // 查询班级信息和班长的信息
    public Optional<Banjiclass> findJoinMon(Long sid){
        SelectStatementProvider sql = select(classId,className,classAmount, monitor.allColumns())
                .from(banjiclass)
                .join(monitor)
                .on(monitoridClass,equalTo(mntId))
                .where(monitoridClass,isEqualTo(sid))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return banji.selectOneJoinWithMon(sql);
    }
}
