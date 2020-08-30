package com.meyou.ssss.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.meyou.ssss.domain.Student;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenService {

    public String getToken(Student student){
        String token= "";
        token = JWT.create()
                .withAudience(Long.toString(student.getStuId()),
                        student.getStuName(),
                        Long.toString(student.getMonitoridStu())
                )
                .sign(Algorithm.HMAC256(student.getStuPassword()));

        return token;
    }

    //解析token
    public static String decodeToken(HttpServletRequest request, int index){
        String token = request.getHeader("token");
        return JWT.decode(token).getAudience().get(index);
    }
}
