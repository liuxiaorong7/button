package example.websocket;

import example.dao.MessageDao;
import example.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/websocket")
@Component
public class Socket {
    @Autowired
    MessageDao messageDao;

    public static Session session;

 @OnOpen
    public void open(Session session) {          //session代表一个管道
        this.session = session;
        System.out.println("sessionid:" + session.getId());
    }

    @OnClose
    public void close(Session session) {
        System.out.println("close");
    }

    @OnError
    public void error(Session session, Throwable t) {
        System.out.println("errorhouduan");
        t.printStackTrace();
    }

    @OnMessage
    public void message(Session session,String msg) {
        System.out.println("kehuduan:" + msg);
        try {
            session.getBasicRemote().sendText("nihao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Socket() {
        System.out.println("socket.socket()");
    }
    public void broadcast1() {
        //System.out.println("nihao");
        Message message = new Message();
        String content = this.messageDao.sendInContent();
        message.setInformation(content);
        try {
            this.session.getBasicRemote().sendText(message.information);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void broadcast2() {
        //System.out.println("nihao");
        Message message = new Message();
        String content = this.messageDao.sendOutContent();
        message.setInformation(content);
        try {
            this.session.getBasicRemote().sendText(message.information);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/**
 *
 *
 * public void broadcast(Session session, String msg) {
 try {
 this.session.getBasicRemote().sendText(msg);
 } catch (IOException e) {
 e.printStackTrace();
 }
 }

 Message message = new Message();
 String content = this.messageDao.sendContent();
 message.setInformation(content);
 */

/**
 String sql1 = "select parkId from freecar where id = @@identity";
 Integer parkId = this.jdbcTemplate.update(sql1,new Object[]{});
 String sql2 = "select freecar from freecar where id = @@identity";
 Integer freecar = this.jdbcTemplate.update(sql2,new Object[]{});
 String m = parkId + "号停车场有车辆进入,剩余车位为："+ freecar;
 Message message = new Message();
 message.setInformation(m);
 **/

/**
 Message message = new Message();
 String content = this.messageDao.sendContent();
 message.setInformation(content);
 this.broadcast(session,message.toJson());


 try {
 //session.getBasicRemote().sendText("nihao");
 } catch (IOException e) {
 e.printStackTrace();
 }
 **/