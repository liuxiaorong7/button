package example.rest;

import example.dao.FreeCarDao;
import example.entity.Park;
import example.service.ParkService;
import example.websocket.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
public class FirstController{
     @Autowired
     ParkService parkService;
    @Autowired
    InsertThread insertThread;
    @Autowired
    DeleteThread deleteThread;
    @Autowired
    FreeCarDao freeCarDao;
    @Autowired
    Socket socket;
   @RequestMapping("/parkInfo")
    public ModelAndView parkInfo(){
      List<Park> parkList = this.parkService.getList();
      ModelAndView mav = new ModelAndView("parkInfo");
      mav.addObject("parkList", parkList);
      return mav;
    }

    @RequestMapping("/topology")
    public ModelAndView topology(){
        return new ModelAndView("/topology");
    }

   @RequestMapping("/insert")
   public ModelAndView insert() {
           try {
               //insertThread.execute();
              this.freeCarDao.insert();
              this.freeCarDao.updateInPark();
              this.freeCarDao.updateFreecar();
              this.socket.broadcast1();
           } catch (Exception e) {
               e.printStackTrace();
           }
       return new ModelAndView("/topology");
   }
    @RequestMapping("/delete")
    public ModelAndView delete() {
        try {
            this.freeCarDao.delete();
            this.freeCarDao.updateOutPark();
            this.freeCarDao.updateFreecar();
            this.socket.broadcast2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/topology");
    }

    @RequestMapping("/stop")
    public ModelAndView stop() {
        try {
            insertThread.close();
            insertThread = null;
            deleteThread.close();
            deleteThread = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    return new ModelAndView("/topology");
   }
   @RequestMapping("/test")
    public ModelAndView test(){
        System.out.println("nihao");
        return new ModelAndView("/topology");
   }
}


/**
   private static final Logger logger = LoggerFactory.getLogger(FirstController.class);
@Autowired
ParkDao parkDao;
 @RestController
public class FirstController {
 @RequestMapping("/")
 public ModelAndView index(){
 return new ModelAndView("/index");

 }
 @RequestMapping("/login")
 public ModelAndView login(HttpServletRequest request) {
 String username = request.getParameter("username");
 if ("liuxiaorong".equals(username)) {
 return new ModelAndView("/ok");
 } else {
 return new ModelAndView("/no");

 }
 }
}
 **/
