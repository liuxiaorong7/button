package example.rest;

import example.dao.FreeCarDao;
import example.dao.MessageDao;
import example.websocket.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataThread {
    @Autowired
    FreeCarDao freeCarDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    Socket socket;
    public void execute() {
        Worker worker = new Worker();
        //new Worker().start();
        worker.start();
    }
    public void close(){
        continueFlag = false;
    }
    boolean continueFlag = true;
    boolean closedFlag = false;
    private class Worker extends Thread {
        public void run() {
            while (continueFlag) {
                try {
                    DataThread.this.freeCarDao.insert();
                    DataThread.this.freeCarDao.updatePark();
                    DataThread.this.freeCarDao.updateFreecar();
                    DataThread.this.socket.broadcast();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try{
                    Worker.sleep(3000);
                }catch (InterruptedException e2){
                    e2.printStackTrace();
                }
            }
            closedFlag = true;
        }
    }
}
/**
 * ScriptEngineManager manager = new ScriptEngineManager();
 ScriptEngine engine = manager.getEngineByName("js");
 try {
 //String path = ExecuteScript.class.getResource("").getPath();
 //System.out.println(path);
 // FileReader的参数为所要执行的js文件的路径
 engine.eval(new FileReader("D:\\Program Files\\intellij idea\\fold\\parking\\src\\main\\resources\\static\\js\\" + "sendMessage.js"));
 if (engine instanceof Invocable) {
 Invocable invocable = (Invocable) engine;
 jsMethods executeMethod = invocable.getInterface(jsMethods.class);
 executeMethod.subSend();
 }
 } catch (Exception e) {
 e.printStackTrace();
 }
 **/