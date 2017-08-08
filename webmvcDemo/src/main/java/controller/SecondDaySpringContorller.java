package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by CHENCO7 on 8/8/2017.
 */
@Controller
public class SecondDaySpringContorller {

    @RequestMapping(value = "/showImg")
    public void showImg(OutputStream out){
        try {
            InputStream in = new FileInputStream("/11.jpg");
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = in.read(buff)) != -1){
                out.write(buff, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/download")
    public byte[] download(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment;filename=xx.jpg");
        InputStream in = new FileInputStream("/11.jpg");
        byte[] buff = new byte[in.available()];
        in.read(buff);
        return buff;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(String uname, MultipartFile img) throws IOException {
        System.out.println(uname);
        System.out.println(img.getOriginalFilename());
        System.out.println(img.getInputStream().available());
        return "suc";
    }

    @RequestMapping(value = "/tt2")
    public String test(){
        System.out.println("test .. ");
        return "suc";
    }
}
