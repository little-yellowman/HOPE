package com.meyou.ssss.controller;

import com.alibaba.fastjson.JSONObject;
import com.meyou.ssss.common.anotation.StuLoginToken;
import com.meyou.ssss.common.constant.ResultCode;
import com.meyou.ssss.common.result.Result;
import com.meyou.ssss.domain.Student;
import com.meyou.ssss.service.StudentService;
import com.meyou.ssss.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class studentController {
    private final StudentService studentService;
    private final TokenService tokenService;

    @Autowired
    public studentController(StudentService studentService, TokenService tokenService) {
        this.studentService = studentService;
        this.tokenService = tokenService;
    }

    //登录
    @PostMapping("/login")
    public Object login(@RequestBody Student form, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        Optional<Student> login = studentService.selectOneById(form.getStuId());
        Result result = new Result();

        if (login.isPresent()){
            if (form.getStuPassword().equals(login.get().getStuPassword())){
                String token = tokenService.getToken(login.get());
                jsonObject.put("token",token);
                jsonObject.put("result",Result.success());

                response.setHeader("token",token);
                return jsonObject;
            }
            else
                result.setResultCode(ResultCode.USER_LOGIN_ERROR);
        }else {
            result.setResultCode(ResultCode.USER_NOT_EXIST);
        }
        jsonObject.put("result",result);
        return jsonObject;
    }

    @PostMapping("/register")
    public Result register(@RequestBody() Student ruleForm){
        if (studentService.selectOneById(ruleForm.getStuId()).isPresent()){
            return Result.error(ResultCode.USER_HAS_EXISTED);
        }

        if(studentService.insertOne(ruleForm) > 0){
            return Result.success();
        }
        return Result.error(ResultCode.ERROR);
    }

    @GetMapping("/ismonitor")
    public boolean isMonitor(HttpServletRequest request){
        String token = TokenService.decodeToken(request,0);
        Optional<Student> student = studentService.selectOneById(Long.valueOf(token));

        return  (student.get().getStuId().equals(student.get().getMonitoridStu()));
    }

    @GetMapping("/findAll")
    @StuLoginToken
    public List<Student> findAll(HttpServletRequest request, Long taskId){
        String token = TokenService.decodeToken(request, 2);

        List<Student> all = studentService.findAll(taskId, Long.valueOf(token));
        // System.out.println(all);
        return all;
    }




    //测试GlobalExceptionHandler
    // @GetMapping("/test0")
    // public double test0(){
    //     return 5/0;
    // }

    //测试tokenInterceptor
    // @GetMapping("/test1")
    // @StuLoginToken
    // public String test1(){
    //     return "hello";
    // }
    //
    // @GetMapping("/test2")
    // public ResponseEntity<String> test2(){
    //     String body = "hello";
    //     String eTag = "eTag";
    //     // System.out.println(ResponseEntity.ok().eTag(eTag).body(body));
    //     return ResponseEntity.ok().eTag(eTag).body(body);
    // }
}
