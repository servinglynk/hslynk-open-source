package com.servinglynk.hmis.warehouse.upload;

import com.servinglynk.hmis.warehouse.upload.config.LoadProcessorSpringConfigV2020;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EnableScheduling
@SpringBootApplication
@Component
public class Processor {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(LoadProcessorSpringConfigV2020.class);
        //BulkUploadWorker worker = context.getBean(BulkUploadWorker.class);
    }
}
