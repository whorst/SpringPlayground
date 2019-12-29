package com.SpringSandbox.SpringSandbox.beans.Annotations;

import org.springframework.context.annotation.Primary;
//https://www.baeldung.com/spring-primary
public class PrimaryAnnotation {
    //If we are creating multiple beans of the same type in the configuration (in the class) stage, we will use the
    //@Primary Annotation. If we were doing this at the injection point (where @AutoWired is) we would use the
    // @Qualifier. This is what it would look like
    /*
    *
    *  @Bean
    public Employee JohnEmployee() {
        return new Employee("John");
    }

    @Bean
    @Primary
    public Employee TonyEmployee() {
        return new Employee("Tony");
    }
    * */
    //If we didn't have the @Primary on line 16, it would be NoUniqueBeanDefinitionException
}
