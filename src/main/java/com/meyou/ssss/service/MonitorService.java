package com.meyou.ssss.service;

import com.meyou.ssss.dao.MonitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {
    private MonitorMapper monitorMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public MonitorService(MonitorMapper monitorMapper) {
        this.monitorMapper = monitorMapper;
    }

}
