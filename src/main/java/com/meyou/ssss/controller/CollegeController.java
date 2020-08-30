package com.meyou.ssss.controller;

import com.meyou.ssss.dao.CollegeMapper;
import com.meyou.ssss.domain.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollegeController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CollegeMapper collegeMapper;

    @GetMapping("/college/findAll")
    public List<College> findAllCollege(){
        return collegeMapper.select(c->c);
    }
}
