package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
public class RegularUtil {
    public static final String DATE = "^((?:19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
    public static final String SEX = "false|true";
    public static final String SALARY = "^[0-9]+([.]\\d{1,2})?$"; // [1-9]\\d\\.\\d{0,2}

    public static boolean regularCheck(String text, String compileText){
        Pattern p = Pattern.compile(compileText);
        Matcher m = p.matcher(text);
        return m.matches();
    }
}
