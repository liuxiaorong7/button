package example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


@Configuration
public class Config {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}

/**
 package example.config;

 import javax.websocket.Endpoint;
 import javax.websocket.server.ServerApplicationConfig;
 import javax.websocket.server.ServerEndpointConfig;
 import java.util.Set;

 public class Config implements ServerApplicationConfig{

@Override
public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
return null;
}

@Override
public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scan) {
System.out.println("lalala");
return scan;
}
}
 **/