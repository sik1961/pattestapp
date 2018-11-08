package com.sik.pattest.config;

import com.sik.pattest.service.PatDataService;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources(
        //       @PropertySource("file:${props.location}/application.properties"),
        @PropertySource("classpath:application.properties")
)
@ComponentScan
public class AppConfig {
    @Bean
    public PatDataService patDataService() {
        return new PatDataService();
    }

}
