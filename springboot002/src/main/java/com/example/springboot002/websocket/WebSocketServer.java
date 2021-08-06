package com.example.springboot002.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/imserver/{userId}")
@Component
public class WebSocketServer {

  /**静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。*/
  private static int onlineCount = 0;
  /**concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
  private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
  /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
  private Session session;
  /**接收userId*/
  private String userId="";

  /**
   * 连接建立成功调用的方法*/
  @OnOpen
  public void onOpen(Session session,@PathParam("userId") String userId) {
    this.session = session;
    this.userId=userId;
    if(webSocketMap.containsKey(userId)){
      webSocketMap.remove(userId);
      webSocketMap.put(userId,this);
      //加入set中
    }else{
      webSocketMap.put(userId,this);
      //加入set中
    }

    try {
      //sendMessage("连接成功");
      this.session.getBasicRemote().sendText("连接成功   " + userId);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @OnClose
  public void onClose() {
    System.out.println("用户退出");
  }
  @OnMessage
  public void onMessage(String message, Session session) {
    System.out.println(message);
  }
  @OnError
  public void onError(Session session, Throwable error) {
    System.out.println("error: " + error.getMessage());
    error.printStackTrace();
  }
  /**
   * 实现服务器主动推送
   */
  public static void sendMessage(String message) throws IOException {
    if (webSocketMap.size() == 0) return ;
    for (Map.Entry<String, WebSocketServer> sessionEntry : webSocketMap.entrySet()) {
      String name = sessionEntry.getKey();
      Session session = sessionEntry.getValue().session;
      session.getAsyncRemote().sendText(message);
    }
  }
}

