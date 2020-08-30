package com.meyou.ssss.controller;

import com.auth0.jwt.JWT;
import com.meyou.ssss.common.anotation.StuLoginToken;
import com.meyou.ssss.common.constant.ResultCode;
import com.meyou.ssss.common.result.Result;
import com.meyou.ssss.dao.SsTaskDynamicSqlSupport;
import com.meyou.ssss.dao.SsTaskMapper;
import com.meyou.ssss.domain.Monitor;
import com.meyou.ssss.domain.SsTask;
import com.meyou.ssss.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/task")
public class TaskController {
    private SsTaskMapper taskMapper;
    private TaskService taskService;

    @Autowired
    public TaskController(SsTaskMapper taskMapper, TaskService taskService) {
        this.taskMapper = taskMapper;
        this.taskService = taskService;
    }

    //根据班长id获得所有task
    //注：写该方法的时候，被提交截图时请求头里面死活封装不上坑了，以为每个方法都不能
    // 封装，所以采取这种下策。后来发现除了上传图片那个图片不能封装，其他都可以，不想改了。。。
    @PostMapping("tasks")
    @StuLoginToken
    public List<SsTask> tasks(@RequestBody Monitor token){

        String monitorId = JWT.decode(token.getMntName()).getAudience().get(2);
        List<SsTask> ssTaskList = taskMapper.select(c -> c
                .where(SsTaskDynamicSqlSupport.moniteridSst, isEqualTo(Long.valueOf(monitorId)))
        );
        return ssTaskList;
    }

    //创建任务
    @PostMapping("/create")
    public Result saveTask(@RequestBody SsTask ruleForm, HttpServletRequest request){
        String monitorId = JWT.decode(request.getHeader("token")).getAudience().get(2);

        int item = taskService.saveTask(ruleForm,Long.valueOf(monitorId));
        // System.out.println(ruleForm);
        return item == 1 ? Result.success():Result.error(ResultCode.ERROR);
    }

    @GetMapping("/history")
    public List<SsTask> findAll(HttpServletRequest request){
        String MonitorId = JWT.decode(request.getHeader("token")).getAudience().get(2);

        return taskService.findAll(Long.valueOf(MonitorId));
    }
}
