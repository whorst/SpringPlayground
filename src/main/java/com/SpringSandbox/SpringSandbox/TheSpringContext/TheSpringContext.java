package com.SpringSandbox.SpringSandbox.TheSpringContext;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TheSpringContext {
    //==================================================================================================================
    //=========================================The Spring Context=======================================================
    //==================================================================================================================

    /*When you see the below code in the Main method, you're creating anew Spring IoC Container, which is responsible
    for the Beans lifecycle. It is also responsible for publishing certain types of events when loading the Beans. For
    example ContextStartedEvent is started when the Context is started. */

    //ApplicationContext ctxTwo = new ApplicationContext(ExampleClass.class);

    /*It is important to close the spring context (container) after use. By closing it, we ensure that it will release
    all the resources and locks that its implementation might hold and will also destroy all the cached singleton beans.*/

    //https://dzone.com/articles/what-is-a-spring-context

}
