package com.SpringSandbox.SpringSandbox.TheSpringContext;

import org.springframework.context.annotation.Bean;

public class ExampleClass {

    @Bean
    public ExampleClass ExampleClass(){
        return new ExampleClass();
    }
}
