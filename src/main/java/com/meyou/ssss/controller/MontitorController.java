package com.meyou.ssss.controller;

import com.meyou.ssss.common.anotation.StuLoginToken;
import com.meyou.ssss.domain.Screenshots;
import com.meyou.ssss.service.ScreenshotService;
import com.meyou.ssss.service.TokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MontitorController {
    private ScreenshotService screenshotService;

    public MontitorController(ScreenshotService screenshotService) {
        this.screenshotService = screenshotService;
    }

    @GetMapping("/findAll")
    @StuLoginToken
    public List<Screenshots> findAll(HttpServletRequest request,Long taskId){
        String token = TokenService.decodeToken(request, 2);

        List<Screenshots> all = screenshotService.findAll(taskId, Long.valueOf(token));
        System.out.println(all);
        return all;
    }
}
