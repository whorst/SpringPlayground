package com.SpringSandbox.SpringSandbox.beans.AnnotationConfiuguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportAnnotationOne {
    //Here's another way to import other beans. Specifying the constructor as a Bean is the first step

    @Bean
    public ImportAnnotationOne ImportAnnotationOne(){
        return new ImportAnnotationOne();
    }
}
