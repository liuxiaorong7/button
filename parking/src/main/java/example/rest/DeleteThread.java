package example.rest;

import example.dao.FreeCarDao;
import example.dao.MessageDao;
import example.websocket.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteThread {
    @Autowired
    FreeCarDao freeCarDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    Socket socket;
    public void execute() {
        Delete delete = new Delete();
        delete.start();
    }
    public void close(){
        continueFlag = false;
    }
    boolean continueFlag = true;
    boolean closedFlag = false;
    private class Delete extends Thread {
        public void run() {
            while (continueFlag) {
                try {
                    DeleteThread.this.freeCarDao.delete();
                    DeleteThread.this.freeCarDao.updateOutPark();
                    DeleteThread.this.freeCarDao.updateFreecar();
                    DeleteThread.this.socket.broadcast2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try{
                    Delete.sleep(3000);
                }catch (InterruptedException e2){
                    e2.printStackTrace();
                }
            }
            closedFlag = true;
        }
    }
}
