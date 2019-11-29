package com.SpringSandbox.SpringSandbox;

import com.SpringSandbox.SpringSandbox.beans.*;
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
//		singletonBean();
//		prototypeBean();
		innerBeans();
	}

	public static void beanLifecycleHooks() {
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

	public static void singletonBean() {
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

	public static void prototypeBean() {
		//Allows one to create MULTIPLE instances of a bean (lmao).
		//https://www.tutorialspoint.com/spring/spring_bean_scopes.htm
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("PrototypeBean.xml");
		PrototypeBean firstBean = (PrototypeBean) context.getBean("PrototypeBean");
		firstBean.setMessage("Bean 1");
		System.out.println(firstBean.getMessage());
		PrototypeBean secondBean = (PrototypeBean) context.getBean("PrototypeBean");
		secondBean.setMessage("Bean 2");
		System.out.println(secondBean.getMessage());
	}

	public static void inheritanceBean() {
		//Beans can be used in an inheritance sort of manner as described here: https://www.tutorialspoint.com/spring/spring_bean_definition_inheritance.htm
		//I don't feel like going through the tutorial right now
	}
	public static void inversionOfControl() {
		//https://www.tutorialspoint.com/spring/spring_dependency_injection.htm
		//Easy to understand concept. Relies on dependency instantiation to happen outside of the specified class
		//and then to be given to the class at class' instantiation

		//Constructor-based dependency injection
		//Constructor-based DI is accomplished when the container invokes a class constructor with a number of arguments,
		//each representing a dependency on the other class.
		//
		//Setter-based dependency injection
		//Setter-based DI is accomplished by the container calling setter methods on your beans after invoking a
		//no-argument constructor or no-argument static factory method to instantiate your bean.
		// but it is a good rule of thumb to use constructor arguments for mandatory dependencies and setters for optional dependencies.
	}

	public static void innerBeans() {
		//https://www.tutorialspoint.com/spring/spring_injecting_inner_beans.htm
		//Just like how Java can have inner classes (classes defined within other classes), the same thing can be done
		//for beans.
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("InnerBeans.xml");
		OuterBean outerBean = (OuterBean) context.getBean("outerBean");
		InnerBean in = (InnerBean) outerBean.getInnerBean();
		in.checkSpelling();
	}

	public static void refsTypes() {
		//
		//The ref attribute
	}
}