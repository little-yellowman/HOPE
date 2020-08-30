package com.meyou.ssss.service;

import com.meyou.ssss.common.utils.MyTimestamp;
import com.meyou.ssss.dao.SsTaskDynamicSqlSupport;
import com.meyou.ssss.dao.SsTaskMapper;
import com.meyou.ssss.domain.SsTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class TaskService {
    private SsTaskMapper taskMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public TaskService(SsTaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Transactional
    public int saveTask(SsTask task, Long monitorId){
        task.setMoniteridSst(monitorId);
        task.setSstId(MyTimestamp.getTimestamp());

        return taskMapper.insertSelective(task);
    }

    //查找任务的历史记录
    public List<SsTask> findAll(Long monitorId){

        return taskMapper.select(c->
                c.where(SsTaskDynamicSqlSupport.moniteridSst, isEqualTo(monitorId)));
    }

    //更新任务
    public int updateTask(SsTask task){

        return taskMapper.updateByPrimaryKeySelective(task);
    }
}
