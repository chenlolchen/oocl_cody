package store.util;

import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * Created by CHENCO7 on 7/27/2017.
 */
public class Base64Util {
    public static String GetImageStr(String path)
    {
        InputStream in = null;
        byte[] data = null;
        try
        {
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return "data:img/jpg;base64," + encoder.encode(data);
    }

    public static void main(String[] args) {
        System.out.println(GetImageStr("d:/test.jpg"));
    }
}
