package com.sik.pattest.config;

import com.sik.pattest.service.PatDataService;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource(value = {
        "classpath:application.properties",
        "classpath:hibernate.properties",
        "file:${app.properties.location}/application.properties",
        "file:${app.properties.location}/hibernate.properties"
}, ignoreResourceNotFound = true)
@ComponentScan
public class AppConfig {
    @Bean
    public PatDataService patDataService() {
        return new PatDataService();
    }

}
