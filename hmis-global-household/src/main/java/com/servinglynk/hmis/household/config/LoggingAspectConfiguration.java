package com.servinglynk.hmis.household.config;

import org.springframework.context.annotation.*;

import com.servinglynk.hmis.household.aop.logging.LoggingAspect;


@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

   @Bean
   
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
