package com.meyou.ssss.common.handler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.meyou.ssss.common.anotation.StuLoginToken;
import com.meyou.ssss.domain.Student;
import com.meyou.ssss.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;

public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private StudentService studentService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //查看是否有@StuLoginToken
        if (method.isAnnotationPresent(StuLoginToken.class)){
            StuLoginToken stuLoginToken = method.getAnnotation(StuLoginToken.class);
            //对token开始验证
            if (stuLoginToken.require()){
                if (Objects.isNull(token)){
                    throw new RuntimeException("请先登录");
                }
                //对token进行解码
                Long sid;
                try {
                    sid = Long.valueOf(JWT.decode(token).getAudience().get(0));
                }catch (JWTDecodeException j){
                    throw new RuntimeException("解析token异常");
                }catch (NumberFormatException n){
                    throw new RuntimeException("无效的token");
                }
                Optional<Student> student = studentService.selectOneById(sid);
                if (!student.isPresent()){
                    throw new RuntimeException("用户不存在，请重新登录");
                }

                //验证token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(student.get().getStuPassword())).build();
                try {
                    jwtVerifier.verify(token);
                }catch (JWTVerificationException e){
                    throw new RuntimeException("401");
                }

            }
        }

        return true;
    }
}
