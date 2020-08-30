package com.meyou.ssss.controller;

import com.auth0.jwt.JWT;
import com.meyou.ssss.common.anotation.StuLoginToken;
import com.meyou.ssss.common.constant.ResultCode;
import com.meyou.ssss.common.result.Result;
import com.meyou.ssss.domain.Banjiclass;
import com.meyou.ssss.service.BanjiClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banji")
public class BanjiClassController {
    private final BanjiClassService banjiService;

    @Autowired
    public BanjiClassController(BanjiClassService banjiService) {
        this.banjiService = banjiService;
    }

    @GetMapping("/findClass")
    public List<Banjiclass> findClass(String grade,Integer majorId){

        return banjiService.findClass(grade,majorId);
    }

    @RequestMapping("/findMyClass")
    @StuLoginToken
    public Result findMyClass(HttpServletRequest request){
        String monitorId = JWT.decode(request.getHeader("token")).getAudience().get(0);

        Optional<Banjiclass> banjiclassOptional = banjiService.findJoinMon(Long.valueOf(monitorId));

        if (banjiclassOptional.isPresent())
            return Result.success(banjiclassOptional.get());
        else
            return Result.error(ResultCode.ERROR);

    }
}
