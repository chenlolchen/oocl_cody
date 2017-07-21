package com.oocl.chat_room.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import com.oocl.chat_room.pojo.User;

public class DomUtil {
	private static final String PORT = "9002";
    private static final String IP = "127.0.0.1";
	
	public static void writeXml(OutputStream out,List<User> userList,Map<String,String> startTimeMap){

        Document dom = new Document();
        Element root = new Element("html");
        Element body = new Element("body");
        Element title = new Element("H1");
        Element form1 = new Element("form");
        Element form2 = new Element("form");
        Element form3 = new Element("form");
        Element form4 = new Element("form");
        Element form5 = new Element("form");
        Element form6 = new Element("form");
        Element form7 = new Element("form");
        Element form8 = new Element("form");
        Element form9 = new Element("form");
        
        Element refresh = new Element("button");
        Element startAll = new Element("button");
        Element serverStart = new Element("button");
        Element registerServerStart = new Element("button");
        Element loginServerStart = new Element("button");
        Element stopAll = new Element("button");
        Element serverStop = new Element("button");
        Element registerStop = new Element("button");
        Element loginStop = new Element("button");
       
        refresh.setText("refresh");
        refresh.setAttribute("type", "submit");
        startAll.setText("startAll");
        startAll.setAttribute("type", "submit");
        serverStart.setText("serverStart");
        serverStart.setAttribute("type", "submit");
        registerServerStart.setText("registerServerStart");
        registerServerStart.setAttribute("type", "submit");
        loginServerStart.setText("loginServerStart");
        loginServerStart.setAttribute("type", "submit");
        
        stopAll.setText("stopAll");
        stopAll.setAttribute("type", "submit");
        serverStop.setText("serverStop");
        serverStop.setAttribute("type", "submit");
        registerStop.setText("registerStop");
        registerStop.setAttribute("type", "submit");
        loginStop.setText("loginStop");
        loginStop.setAttribute("type", "submit");
        
        
        if(startTimeMap!=null){
	        Iterator<Map.Entry<String, String>> it = startTimeMap.entrySet().iterator();
	        long time = new Date().getTime();
	        
	        while (it.hasNext()) {
	        Map.Entry<String, String> entry = it.next();
	        Element timeElement = new Element("H3");
	        String runTime = DateUtil.getTimeInterval(entry.getValue(), DateUtil.formatDate(time));
	        timeElement.setText(entry.getKey()+entry.getValue()+"\t run time:\t"+runTime);
	        // System.out.println(DateUtil.getTimeInterval(entry.getValue(), DateUtil.formatDate(time)));
	        body.addContent(timeElement);
	        }
        }
        
        form1.setAttribute("action", "http://" +IP + ":" + PORT + "/refresh");
        form1.setAttribute("method", "post");
        form1.addContent(refresh);
        
        form2.setAttribute("action", "http://" +IP + ":" + PORT + "/startAll");
        form2.setAttribute("method", "post");
        form2.addContent(startAll);
        
        form3.setAttribute("action", "http://" +IP + ":" + PORT + "/serverStart");
        form3.setAttribute("method", "post");
        form3.addContent(serverStart);
        
        form4.setAttribute("action", "http://" +IP + ":" + PORT + "/registerServerStart");
        form4.setAttribute("method", "post");
        form4.addContent(registerServerStart);
        
        form5.setAttribute("action", "http://" +IP + ":" + PORT + "/loginServerStart");
        form5.setAttribute("method", "post");
        form5.addContent(loginServerStart);
        
        form6.setAttribute("action", "http://" +IP + ":" + PORT + "/stopAll");
        form6.setAttribute("method", "post");
        form6.addContent(stopAll);
        form7.setAttribute("action", "http://" +IP + ":" + PORT + "/serverStop");
        form7.setAttribute("method", "post");
        form7.addContent(serverStop);
        form8.setAttribute("action", "http://" +IP + ":" + PORT + "/registerStop");
        form8.setAttribute("method", "post");
        form8.addContent(registerStop);
        form9.setAttribute("action", "http://" +IP + ":" + PORT + "/loginStop");
        form9.setAttribute("method", "post");
        form9.addContent(loginStop);
        
        
        body.addContent(title);
        body.addContent(form1);
        body.addContent(form2);
        body.addContent(form3);
        body.addContent(form4);
        body.addContent(form5);
        body.addContent(form6);
        body.addContent(form7);
        body.addContent(form8);
        body.addContent(form9);
        root.addContent(body);

        if(userList != null){
        	Element ul = new Element("ul");
        	for(User user:userList){
        		Element li = new Element("li");
        		li.setText(user.getName());
        		if(user.isStatus()){
        			li.setAttribute("style","color:green");
        		}
        		else{
        			li.setAttribute("style","color:red");
        		}
        		ul.addContent(li);
        	}
       	body.addContent(ul);
       	dom.setRootElement(root);
        }
        
        XMLOutputter outputter = new XMLOutputter();
        try {
			out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
			outputter.output(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		}

        System.out.println("header end ...");

	}
}
