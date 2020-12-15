package com.cloudwise.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : Enzo
 * @version : 1.0
 * @date : Created on 2020/12/14 14:40
 * @description : my own tools
 * @modifiedBy :
 */
public class EnzoTools {
    /**
     * @return : String
     * @create by : Enzo
     * @description : 传递两个格式为HH:mm:ss的字符串型时间,计算并返回两个时间的时间差
     * @create time : 2020/11/24 19:20
     */
    public static String timeDifference(String startTime, String endTime) {
        //声明一个用于获得期间时间LocalDateTime
        LocalDateTime durationTime;
        //设置一个标准日期
        String levelDate = "1970-01-01T";
        //设置时间格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        //获取两个时间的差值
        Duration duration = Duration.between(LocalDateTime.parse(levelDate + startTime), LocalDateTime.parse(levelDate + endTime));
        //判断小时数是否大于10
        if (duration.toHours() % 24 >= 10) {
            //判断分钟数是否大于10
            if (duration.toMinutes() % 60 >= 10) {
                //判断秒数是否大于10
                if (duration.toMillis() / 1000 % 60 % 60 >= 10) {
                    durationTime = LocalDateTime.parse(levelDate + duration.toHours() + ":" + duration.toMinutes() % 60 + ":" + duration.toMillis() / 1000 % 60 % 60);
                } else {
                    durationTime = LocalDateTime.parse(levelDate + duration.toHours() + ":" + duration.toMinutes() % 60 + ":0" + duration.toMillis() / 1000 % 60 % 60);
                }
            } else {
                if (duration.toMillis() / 1000 % 60 % 60 >= 10) {
                    durationTime = LocalDateTime.parse(levelDate + duration.toHours() + ":0" + duration.toMinutes() % 60 + ":" + duration.toMillis() / 1000 % 60 % 60);
                } else {
                    durationTime = LocalDateTime.parse(levelDate + duration.toHours() + ":0" + duration.toMinutes() % 60 + ":0" + duration.toMillis() / 1000 % 60 % 60);
                }
            }
        } else {
            if (duration.toMinutes() % 60 >= 10) {
                if (duration.toMillis() / 1000 % 60 % 60 >= 10) {
                    durationTime = LocalDateTime.parse(levelDate + "0" + duration.toHours() + ":" + duration.toMinutes() % 60 + ":" + duration.toMillis() / 1000 % 60 % 60);
                } else {
                    durationTime = LocalDateTime.parse(levelDate + "0" + duration.toHours() + ":" + duration.toMinutes() % 60 + ":0" + duration.toMillis() / 1000 % 60 % 60);
                }
            } else {
                if (duration.toMillis() / 1000 % 60 % 60 >= 10) {
                    durationTime = LocalDateTime.parse(levelDate + "0" + duration.toHours() + ":0" + duration.toMinutes() % 60 + ":" + duration.toMillis() / 1000 % 60 % 60);
                } else {
                    durationTime = LocalDateTime.parse(levelDate + "0" + duration.toHours() + ":0" + duration.toMinutes() % 60 + ":0" + duration.toMillis() / 1000 % 60 % 60);
                }
            }
        }
        //返回时间格式化后的字符串
        return durationTime.format(dateTimeFormatter);
    }

    /**
     * @param page,limit
     * @return : int
     * @createBy : Enzo
     * @description : table分页
     * @createTime : 2020/12/14 14:47
     */
    public static int offset(int page, int limit) {
        return (page - 1) * limit;
    }
}
