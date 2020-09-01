package com.meyou.ssss.common.utils;

import com.meyou.ssss.domain.Banjiclass;
import com.meyou.ssss.domain.Student;
import com.meyou.ssss.service.BanjiClassService;
import com.meyou.ssss.service.StudentService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Component
public class Path {
    private StudentService studentService;
    private BanjiClassService banji;

    public Path(StudentService studentService, BanjiClassService banji) {
        this.studentService = studentService;
        this.banji = banji;
    }

    /*
    *@Description:生成访问图片的基础路径
    *@Author:yyl
    *@Param:sid：学号，taskId：任务的id
    *@Return:返回一个学院+专业+班级+任务id的字符串
    */
    public String  basePath(Long sid, Long taskId){
        Student student = studentService.selectOneById(sid).get();
        Banjiclass monitor = banji.findByMonitorId(student.getMonitoridStu()).get();

        StringBuilder sb = new StringBuilder();
        String separator = File.separator;
        //存储在本地的路径
        String path = sb
                .append(student.getCollegenameStu()).append(separator)
                .append(student.getMajornameStu()).append("-")
                .append(monitor.getClassName()).append(separator)
                .append(taskId).append(separator)
                .toString();

        return path;
    }

    /*
     *@Description:生成访问图片的基础路径
     *@Author:yyl
     *@Param:sid：学号，taskId：任务的id
     *@Return:返回一个学院+专业+班级的字符串
     */
    public String  basePath(Long sid){
        Student student = studentService.selectOneById(sid).get();
        Banjiclass monitor = banji.findByMonitorId(student.getMonitoridStu()).get();

        StringBuilder sb = new StringBuilder();
        String separator = File.separator;
        //存储在本地的路径
        String path = sb
                .append(student.getCollegenameStu()).append(separator)
                .append(student.getMajornameStu()).append("-")
                .append(monitor.getClassName()).append(separator)
                .toString();

        return path;
    }

    public String imgName(Long sid){
        Student student = studentService.selectOneById(sid).get();

        return student.getStuId() + student.getStuName() + ".png";
    }

    public static String osPath(){
        String osName = System.getProperties().getProperty("os.name");

        if (osName.toUpperCase().startsWith("WIN")){
            return "f:\\";
        }
        return "/users/";
    }

    //获取请求头的前缀
    public static String getRequestPrefix (HttpServletRequest request) {
        // 网络协议
        String networkProtocol = request.getScheme();
        // 网络ip
        String ip = request.getServerName();
        // 端口号
        int port = request.getServerPort();
        // 项目发布名称
        String webApp = request.getContextPath();
        return networkProtocol + "://" + ip + ":" + port + webApp;
    }
}
