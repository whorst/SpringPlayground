package com.SpringSandbox.SpringSandbox.beans.AnnotationConfiuguration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DefiningScope {

    @Bean
    @Scope("prototype")
    //Oh wow look that is how you define the bean scope
    //https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
    public static MyRequiredBean getBean() {
        return new MyRequiredBean();
    }

}
