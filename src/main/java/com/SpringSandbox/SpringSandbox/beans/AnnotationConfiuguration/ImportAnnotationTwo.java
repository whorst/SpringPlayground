package com.SpringSandbox.SpringSandbox.beans.AnnotationConfiuguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//After the setup in the first class, in the second class you just have the import statement on line 8
@Configuration
@Import(ImportAnnotationOne.class)
public class ImportAnnotationTwo {
    @Bean
    public ImportAnnotationTwo ImportAnnotationTwo(){
        return new ImportAnnotationTwo();
    }
}
