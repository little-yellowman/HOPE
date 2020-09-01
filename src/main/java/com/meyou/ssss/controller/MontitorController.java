package com.meyou.ssss.controller;

import com.auth0.jwt.JWT;
import com.meyou.ssss.common.anotation.StuLoginToken;
import com.meyou.ssss.common.constant.ResultCode;
import com.meyou.ssss.common.result.Result;
import com.meyou.ssss.common.utils.FileToZip;
import com.meyou.ssss.common.utils.Path;
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
    private Path pa;
    public MontitorController(ScreenshotService screenshotService, Path pa) {
        this.screenshotService = screenshotService;
        this.pa = pa;
    }

    @GetMapping("/findAll")
    @StuLoginToken
    public List<Screenshots> findAll(HttpServletRequest request,Long taskId){
        String token = TokenService.decodeToken(request, 2);

        List<Screenshots> all = screenshotService.findAll(taskId, Long.valueOf(token));
        System.out.println(all);
        return all;
    }

    /*
    *@Description:将图片打包为压缩包，提供下载地址
    *@Author:yyl
    *@Param:[response]
    *@Return:void
    */
    @GetMapping("/download")
    public Result download(HttpServletRequest request, Long taskId){
        String monitorId = JWT.decode(request.getHeader("token")).getAudience().get(0);
        String path = pa.basePath(Long.valueOf(monitorId),taskId);
        String fileName = monitorId+taskId;
        String zipPath = pa.basePath(Long.valueOf(monitorId));
        try {
            FileToZip.fileToZip(Path.osPath()+path,Path.osPath()+zipPath,fileName);
        }catch (Exception e){
            return Result.error(ResultCode.ERROR);
        }

        return Result.success(Path.getRequestPrefix(request) + "/img/" + zipPath + fileName+".zip");

    }
}
