package config;

import beans.MyBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    public MyBean myBean(){
        return myBean();
    }
}
