package com.SpringSandbox.SpringSandbox.TheSpringContext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;


public class CStartEventHandler implements ApplicationListener<ContextStartedEvent>{
//https://www.tutorialspoint.com/spring/event_handling_in_spring.htm

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("ContextStartedEvent Received");
    }
}
