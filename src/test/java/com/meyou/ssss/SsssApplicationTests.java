package com.meyou.ssss;

import com.meyou.ssss.service.BanjiClassService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsssApplicationTests {
    private BanjiClassService banjiClassService;

    @Autowired
    SsssApplicationTests(BanjiClassService banjiClassService) {
        this.banjiClassService = banjiClassService;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void banjiJoinMonitorTest(){
        System.out.println(banjiClassService.findJoinMon(201713453131l));
    }

}
