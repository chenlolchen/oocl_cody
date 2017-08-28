import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws1")
public class MyWebSocket {
    public MyWebSocket() {
        System.out.println("contructing.....");
    }
    @OnOpen
    public void onOpen(Session sen){
        System.out.println("on open....");
    }
    @OnClose
    public void onClose(Session sen){
        System.out.println("on close....");
    }

    @OnError
    public void onError(Session sen,Throwable e){
        System.out.println("on error....");
    }

    @OnMessage
    public void onMessage(String msg,Session sen){
        System.out.println("data is:"+msg);
        try {
            sen.getBasicRemote().sendText("Hello:"+msg);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}