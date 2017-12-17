package example.rest;

import example.dao.FreeCarDao;
import example.dao.MessageDao;
import example.websocket.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertThread {
    @Autowired
    FreeCarDao freeCarDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    Socket socket;
    public void execute() {
        Worker worker = new Worker();
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
                    InsertThread.this.freeCarDao.insert();
                    InsertThread.this.freeCarDao.updateInPark();
                    InsertThread.this.freeCarDao.updateFreecar();
                    InsertThread.this.socket.broadcast1();
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