package com.oocl.chat_room.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chen on 2017/7/16.
 */
public class DateUtil {
    public static String formatDate(Long time){
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
