package com.oocl.chat_room.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chen on 2017/7/16.
 */
public class DateUtil {
    public static String formatDate(Long time) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }

    /**
     * 计算运行时间长
     * @param startDate yyyy-MM-dd HH:mm:ss
     * @param endDate yyyy-MM-dd HH:mm:ss
     * @return day + "天" + hour + "小时" + min + "分" + s + "秒"
     */
    public static String getTimeInterval(String startDate, String endDate) {
        String time = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            Date now = simpleDateFormat.parse(endDate);
            Date date = simpleDateFormat.parse(startDate);
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            time = "" + day + " day " + hour + " hours " + min + " minutes " + s + " seconds ";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

}
