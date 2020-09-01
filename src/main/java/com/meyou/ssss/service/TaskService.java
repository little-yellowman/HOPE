package com.meyou.ssss.service;

import com.meyou.ssss.common.utils.MyTimestamp;
import com.meyou.ssss.common.utils.Path;
import com.meyou.ssss.dao.SsTaskDynamicSqlSupport;
import com.meyou.ssss.dao.SsTaskMapper;
import com.meyou.ssss.domain.SsTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class TaskService {
    private SsTaskMapper taskMapper;
    private Path pa;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public TaskService(SsTaskMapper taskMapper, Path pa) {
        this.taskMapper = taskMapper;
        this.pa = pa;
    }

    /*
    *@Description:通过sstId主键查找一条任务
    *@Author:yyl
    *@Param:[sstId]
    *@Return:java.util.Optional<com.meyou.ssss.domain.SsTask>
    */
    public Optional<SsTask> findOne(Long sstId){

        return taskMapper.selectByPrimaryKey(sstId);
    }

    @Transactional
    public int saveTask(SsTask task, Long monitorId){
        task.setMoniteridSst(monitorId);
        task.setSstId(MyTimestamp.getTimestamp());

        //创建目录，保存同学截图的本地地址
        File file = new File(Path.osPath() + pa.basePath(monitorId,task.getSstId()));
        boolean success = file.mkdirs();

        if (success) {
            return taskMapper.insertSelective(task);
        }
        else {
            throw new RuntimeException("失败");
        }
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

    /*
    *@Description:根据主键删除创建的主键
    *@Param:任务主键
    *@Return:
    */
    public int delTask(Long sstId){

        return taskMapper.deleteByPrimaryKey(sstId);
    }
}
