package example.rest;

///    @RequestMapping("/test")
 //   public String test(){
 //       System.out.println("sssssssssss");
  //      return  "parkInfo.html";
  //  }

import example.entity.Park;
import example.service.FreeCarService;
import example.service.ParkService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class FirstController{
 @Autowired
 ParkService parkService;

@Autowired
    FreeCarService freeCarService;
@Autowired
DataThread dataThread;
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
   @RequestMapping("/start")
   public ModelAndView start(HttpServletRequest request) {
       if (StringUtils.isNotBlank(request.getParameter("insert"))) {
           try {
              // dataThread.execute();
               CloseableHttpClient client = HttpClients.createDefault();
               HttpGet httpGet = new HttpGet("http://localhost:8888/insert");
               CloseableHttpResponse resp = client.execute(httpGet);
               resp.close();
           }catch (Exception e){
               e.printStackTrace();
           }
       }
       if (StringUtils.isNotBlank(request.getParameter("delete"))) {
           try {
               // dataThread.execute();
               CloseableHttpClient client = HttpClients.createDefault();
               HttpGet httpGet = new HttpGet("http://localhost:8888/delete");
               CloseableHttpResponse resp = client.execute(httpGet);
               resp.close();
           }catch (Exception e){
               e.printStackTrace();
           }
       }
       if (StringUtils.isNotBlank(request.getParameter("stop"))) {
           try {
               CloseableHttpClient client = HttpClients.createDefault();
               HttpGet httpGet = new HttpGet("http://localhost:8888/stop");
               CloseableHttpResponse resp = client.execute(httpGet);
               resp.close();
           }catch (Exception e){
               e.printStackTrace();
           }
       }
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
