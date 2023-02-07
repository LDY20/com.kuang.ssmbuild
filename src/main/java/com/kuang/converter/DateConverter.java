package com.kuang.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//测试自定义类型转换器
public class DateConverter implements Converter<String, Date> { //这Converter方法中两个参数是将String类型的转为Date类型

    public Date convert(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
