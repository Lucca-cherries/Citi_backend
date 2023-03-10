package com.citi.stock.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间戳转换工具类
 */
@Slf4j
public class Timestamp {
    public static String timeStamp2Date(String seconds,String format) {
        log.debug("Call timestamp util for {}", seconds);
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
}
