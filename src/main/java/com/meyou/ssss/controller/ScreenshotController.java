package com.meyou.ssss.controller;

import com.auth0.jwt.JWT;
import com.meyou.ssss.common.anotation.StuLoginToken;
import com.meyou.ssss.common.constant.ResultCode;
import com.meyou.ssss.common.result.Result;
import com.meyou.ssss.common.utils.MyTimestamp;
import com.meyou.ssss.domain.Banjiclass;
import com.meyou.ssss.domain.Screenshots;
import com.meyou.ssss.domain.Student;
import com.meyou.ssss.service.BanjiClassService;
import com.meyou.ssss.service.ScreenshotService;
import com.meyou.ssss.service.StudentService;
import com.meyou.ssss.service.TokenService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/screenshot")
public class ScreenshotController {
    private StudentService studentService;
    private BanjiClassService banji;
    private ScreenshotService screenshotService;

    public ScreenshotController(StudentService studentService, BanjiClassService banji, ScreenshotService screenshotService) {
        this.studentService = studentService;
        this.banji = banji;
        this.screenshotService = screenshotService;
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
        Student student = studentService.selectOneById(sid).get();
        Banjiclass monitor = banji.findByMonitorId(student.getMonitoridStu()).get();

        StringBuilder sb = new StringBuilder();
        String separator = File.separator;
        //存储在本地的路径
        String path = sb.append("F:").append(separator)
                .append(student.getCollegenameStu()).append(separator)
                .append(student.getMajornameStu()).append("-")
                .append(monitor.getClassName()).append(separator)
                .append(screenshots.getTaskidScrnsht()).append(separator)
                .append(student.getStuId()).append(student.getStuName())
                .append(".png")
                .toString();

        //拼装组合screenshots对象
        screenshots.setPath(path);
        screenshots.setScrnshtId(jwtsid + MyTimestamp.getTimestamp());
        screenshots.setStudentidScrnsht(sid);

        try {
            File f = new File(path);
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

        return !screenshot.isPresent();
    }

    @PostMapping("/test")
    public MultipartFile test(){
        InputStream inputStream = null;
        File f = new File("F:\\数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术\\1597909069174\\201713453131袁宇林.png");
        try {
            inputStream = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        MultipartFile file = (MultipartFile) inputStream;
        return file;
    }
}
