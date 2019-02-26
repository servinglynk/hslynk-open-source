package com.servinglynk.hmis.warehouse.upload;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.servinglynk.hmis.warehouse.upload.config.ChronicHomelessConfig;
import com.servinglynk.hmis.warehouse.upload.service.ChronicHomelessnesCalculator;

public class ChronicHomelessProcessor {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(ChronicHomelessConfig.class);
        ChronicHomelessnesCalculator worker = (ChronicHomelessnesCalculator) context.getBean(ChronicHomelessnesCalculator.class);
        worker.processWorkerLine();
    }
}
