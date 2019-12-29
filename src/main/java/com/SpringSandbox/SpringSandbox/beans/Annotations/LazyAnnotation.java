package com.SpringSandbox.SpringSandbox.beans.Annotations;

//By default, the Spring IoC container creates and initializes all singleton beans at time of application startup.
// We can prevent this pre-initialization of a singleton bean by using the @Lazy annotation.
//https://www.javaguides.net/2018/10/spring-lazy-annotation-example.html
public class LazyAnnotation {

    /*
    *package net.javaguides.spring.lazy;

    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Lazy;

    @Configuration
    public class AppConfig {

        @Lazy(value = true)
        @Bean
        public FirstBean firstBean() {
            return new FirstBean();
        }

        @Bean
        public SecondBean secondBean() {
            return new SecondBean();
        }
    }
    * */
}
