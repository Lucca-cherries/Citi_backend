package com.citi.stock.util;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 上传文件string类型转date类型的工具类
 */
@Slf4j
public class StringToDate extends AbstractBeanField {

    @Override
    protected Date convert(String s) throws CsvDataTypeMismatchException,
            CsvConstraintViolationException {
        log.debug("Call string2date for {}", s);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date =null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            log.error("Parse date error.");
            e.printStackTrace();
        }
        return date;
    }
}
