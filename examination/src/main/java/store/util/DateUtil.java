package store.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chen on 2017/7/16.
 */
public class DateUtil {
    public static Date formatDate(String dateString){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
