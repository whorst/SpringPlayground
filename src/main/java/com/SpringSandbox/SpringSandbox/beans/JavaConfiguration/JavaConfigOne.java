package com.SpringSandbox.SpringSandbox.beans.JavaConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigOne {

    @Bean
    public JavaConfigTwo javaConfigTwo(){
        /*
        * This method is a bean because it returns another object. It is meant to define the dependencies between the
        * two
        * */
        return new JavaConfigTwo();
    }
}
