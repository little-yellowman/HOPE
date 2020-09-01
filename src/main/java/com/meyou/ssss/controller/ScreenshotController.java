package com.meyou.ssss.controller;

import com.auth0.jwt.JWT;
import com.meyou.ssss.common.anotation.StuLoginToken;
import com.meyou.ssss.common.constant.ResultCode;
import com.meyou.ssss.common.result.Result;
import com.meyou.ssss.common.utils.MyTimestamp;
import com.meyou.ssss.common.utils.Path;
import com.meyou.ssss.domain.Screenshots;
import com.meyou.ssss.service.ScreenshotService;
import com.meyou.ssss.service.TokenService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/screenshot")
public class ScreenshotController {
    private ScreenshotService screenshotService;
    private Path pa;

    public ScreenshotController( ScreenshotService screenshotService, Path path) {
        this.screenshotService = screenshotService;
        this.pa = path;
    }


    @PostMapping("/upload")
    @StuLoginToken
    public Result upload(@RequestParam("file")MultipartFile file, HttpServletRequest request,Screenshots screenshots){
        // System.out.println(file.getOriginalFilename());
        if (Objects.isNull(screenshots.getTaskidScrnsht())){
            return Result.error(ResultCode.ERROR);
        }
        String token = request.getHeader("token");
        String jwtsid = JWT.decode(token).getAudience().get(0);
        long sid = Long.valueOf(jwtsid);

        String path = pa.basePath(sid,screenshots.getTaskidScrnsht()) + pa.imgName(sid);

        //拼装组合screenshots对象
        screenshots.setPath(path);
        screenshots.setScrnshtId(jwtsid + MyTimestamp.getTimestamp());
        screenshots.setStudentidScrnsht(sid);

        try {
            File f = new File(Path.osPath()+path);
            //保存图片
            file.transferTo(f);
            int success = screenshotService.saveScreenShot(screenshots);
            if (success > 0) return Result.success();
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error(ResultCode.ERROR);
        }
        return Result.error(ResultCode.ERROR);
    }

    @GetMapping("/isuploaded")
    @StuLoginToken
    public boolean isUploaded(HttpServletRequest request,Long taskId){
        String stuId = TokenService.decodeToken(request, 0);
        Optional<Screenshots> screenshot = screenshotService.findOne(Long.valueOf(stuId), taskId);

        if (screenshot.isPresent()){
            screenshotService.delScreenshot(screenshot.get().getScrnshtId());
        }
        return !screenshot.isPresent();
    }

    @GetMapping("/findAll")
    @StuLoginToken
    public List<Screenshots> findAll(Long taskId,HttpServletRequest request){
        String monitorId = JWT.decode(request.getHeader("token")).getAudience().get(2);

        String prefix = Path.getRequestPrefix(request);
        List<Screenshots> all = screenshotService.findAll(taskId,Long.valueOf(monitorId));
        for (Screenshots scr : all) {
            //拼接访问的路径
            String path = scr.getPath();
            StringBuilder sb = new StringBuilder();
            sb.append(prefix).append("/img/").append(path);
            String url = sb.toString();
            scr.setPath(url);

            //设置图片放大时的访问路径
            List<String> term = new ArrayList<>();
            term.add(url);
            scr.setSrcList(term);
        }
        return all;
    }


}
