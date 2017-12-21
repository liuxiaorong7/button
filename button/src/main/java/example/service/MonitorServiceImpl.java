/**
package example.service;

import example.thread.MonitorThread;
import org.springframework.stereotype.Service;

@Service
public class MonitorServiceImpl implements MonitorService{
    public MonitorThread monitorThread = new MonitorThread();
    @Override
    public MonitorThread getMonitorThread() {
        return monitorThread;
    }
    @Override
    public void setMonitorThread(MonitorThread monitorThread) {
        this.monitorThread = monitorThread;
    }
    @Override
    public boolean start() throws Exception{
        MonitorThread monitorThread=new MonitorThread();
        monitorThread.start();
        return true;
    }
    @Override
    public boolean stop() throws Exception{
        monitorThread.close();
        while(monitorThread.closed()){
            break;
        }
        monitorThread = null;
        return true;
    }
}
**/