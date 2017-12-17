/**
package example.thread;

import example.dao.FreeCarDao;
import example.entity.FreeCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

//@Component
@Service
public class MonitorThread extends Thread {

    @Autowired
    FreeCarDao freeCarDao;
    //FreeCarDao freeCarDao = (FreeCarDao) SpringContextUtil.getBean("freeCarDao");
    private boolean continueFlag = true;
    private boolean closedFlag = false;

    public void run() {
        while (continueFlag) {
            try {
                FreeCar freeCar = new FreeCar();
                Integer max=8;
                Integer min=1;
                Random random = new Random();
                freeCar.setParkId(random.nextInt(max)%(max-min+1)+min);
                this.freeCarDao.insert();
                this.freeCarDao.updatePark();
                this.freeCarDao.updateFreecar();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try{
                MonitorThread.sleep(5000);
            }catch (InterruptedException e2){
                e2.printStackTrace();
            }
        }
        closedFlag = true;
    }
    public void close(){
        continueFlag = false;
    }
    public boolean closed(){
        return closedFlag;
    }

}
 **/