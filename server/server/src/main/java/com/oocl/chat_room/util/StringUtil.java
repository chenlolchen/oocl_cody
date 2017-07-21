package com.oocl.chat_room.util;

import java.io.BufferedReader;
import java.io.IOException;

public class StringUtil {

	public static String getStatus(BufferedReader reader){
		  String line = null;
          int count = 0;
          String status = null;
          try {
			while ((line = reader.readLine()).trim().length() != 0 && count != 1) {
//			  	System.out.println("原状态"+line);
			  	if(++count == 1){
			  	   status = line.substring(line.indexOf("/")+1, line.lastIndexOf(" "));
//			  	   System.out.println("要求的字符串"+status);
			     }
			  }
		} catch (IOException e) {
			e.printStackTrace();
		}
          return status;
	}
	
}
