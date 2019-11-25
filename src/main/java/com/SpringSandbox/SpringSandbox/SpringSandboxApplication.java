package com.SpringSandbox.SpringSandbox;

import com.SpringSandbox.SpringSandbox.beans.LifecycleHooks;
import com.SpringSandbox.SpringSandbox.beans.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.text.AbstractDocument;


@SpringBootApplication
public class SpringSandboxApplication {

	public static void main(String[] args) {

      SpringApplication.run(SpringSandboxApplication.class, args);
//      beanLifecycleHooks();
		singletonBean();
	}

	public static void beanLifecycleHooks () {
		//This is used to monitor lifecycle of a bean
		//https://www.tutorialspoint.com/spring/spring_bean_life_cycle.htm
		//See LifecycleHook.xml for details
		//Beans don't only have to be declared by creating a related .xml Another Way to do it is to use the @Bean
		// Annotation as per this article https://docs.spring.io/spring-javaconfig/docs/1.0.0.m3/reference/html/creating-bean-definitions.html
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("LifecycleHook.xml");
      	LifecycleHooks x = (LifecycleHooks) context.getBean("example");
      	x.getMessage();
      	x.destroy();
      	context.registerShutdownHook();
	}

	public static void singletonBean () {
		//When creating a bean to be used in the app, one may want to only create one instance of a bean to be used in the.
		// This would be a singleton bean, the definition of which can be found in SingletonBean.xml. As long as it is declared once,
		//It will always return what it's instantiated as.
		//https://www.tutorialspoint.com/spring/spring_bean_scopes.htm
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("SingletonBean.xml");
		SingletonBean x = (SingletonBean) context.getBean("SingletonBean");
		x.setMessage("First Bean");
		System.out.println(x.getMessage());
		SingletonBean y = (SingletonBean) context.getBean("SingletonBean");
		System.out.println(y.getMessage());
	}

}
