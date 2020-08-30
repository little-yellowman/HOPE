package com.meyou.ssss.common.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MyTimestamp {
    public static long getTimestamp(){
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

        return timestamp.getTime();
    }
}
