package com.SpringSandbox.SpringSandbox.TheSpringContext;

public class SpringEvents {

    //==================================================================================================================
    //=========================================Spring Event Handling====================================================
    //==================================================================================================================


    //*Application Context, which we have seen thus far manages the lifecycle of the Beans. It is also responsible for
    //publishing certain types of events when loading the Beans. For example ContextStartedEvent is started when the
    //Context is started.

    //There are five following Spring Events
    //1) ContextRefreshedEvent - This event is published when the ApplicationContext is either initialized or refreshed.
    //Can be raised using the refresh() method on ConfigurableApplicationContext interface.

    //2) ContextStartedEvent - The event is published when ApplicationContext is started using the start() method on
    //ConfigurableApplicationContext interface.

    //3) ContextStoppedEvent - The event is published when the ApplicationContext is stopped using the stop() method
    //on ConfigurableApplicationContext interface.

    //4) ContextClosedEvent - The event is published when the ApplicationContext is closed using the close() method
    //on ConfigurableApplicationContext interface.

    //5) RequestHandledEvent - A web-specific event telling all beans that an HTTP request has been serviced

    //Spring's event handling is single threaded. Until all receivers get the message, the processes are blocked.
    //Albert Recommends looking into the qualifier annotation

    //There is an ApplicationListener interface which has a method onApplicationEvent()

}
