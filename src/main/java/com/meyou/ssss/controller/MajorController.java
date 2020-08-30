package com.meyou.ssss.controller;

import com.meyou.ssss.dao.MajorMapper;
import com.meyou.ssss.domain.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.meyou.ssss.dao.MajorDynamicSqlSupport.collegenameMjr;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@RestController
public class MajorController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MajorMapper mapper;

    @GetMapping("/major/findMajors")
    public List<Major> findMajors(@RequestParam("collegenameStu") final String collegenameStu){

        return mapper.select(c->
                c.where(collegenameMjr, isEqualTo(collegenameStu))
                );
    }
}
