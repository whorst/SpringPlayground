package com.SpringSandbox.SpringSandbox;

import com.SpringSandbox.SpringSandbox.TheSpringContext.CEventHandlerClass;
import com.SpringSandbox.SpringSandbox.beans.*;
import com.SpringSandbox.SpringSandbox.beans.AnnotationConfiuguration.*;
import com.SpringSandbox.SpringSandbox.beans.JavaConfiguration.JavaConfigOne;
import com.SpringSandbox.SpringSandbox.beans.JavaConfiguration.JavaConfigTwo;
import com.SpringSandbox.SpringSandbox.beans.NamedAutoWiring.AutoWiringOne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
//@EnableFeignClients
public class SpringSandboxApplication {

	//To Research: Lazy Bean Initialization, The SpringSecurityContext, Qualifier Annotations, Bean Factories

	//The Difference between a BeanFactory and an Application Context, is a BeanFactory is an interface for interacting
	//with Beans, while the ApplicationContext is used to provide configuration info for the application. The context
	//actually uses the bean factory  https://dzone.com/articles/difference-between-beanfactory-and-applicationcont

	public static void main(String[] args) {

		//The Feign Client Dependencies cause the program to fail, need to investigate why. prolly has something to do with
		//Spring Cloud

		SpringApplication.run(SpringSandboxApplication.class, args);
//		beans();
//		events();

	}

	public static void beans() {
		beanLifecycleHooks();
		singletonBean();
		prototypeBean();
		innerBeans();
		autoWiringByName();
		annotationRequiredConfiguration();
		annotationAutoWiredConfiguration();
	}

	public static void events() {
		startStopEvents();
	}

	public static void startStopEvents(){
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("StartStopEvents.xml");

		context.start();
		//The Classes CStartEventHandler and CStopEventHandler
		CEventHandlerClass cEventHandlerClass = (CEventHandlerClass)  context.getBean("cEventHandlerClass");
		cEventHandlerClass.getMessage();

		context.stop();
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
	public static void autoWiringByName() {
		//The Spring Container Handles Autowiring of dependencies. Autowiring will handle relationships between related
		// beans. It cuts down on the amount of XML config needed
		//https://www.tutorialspoint.com/spring/spring_beans_autowiring.htm

		ApplicationContext ctx = new ClassPathXmlApplicationContext("NamedAutoWiringBeans.xml");
		AutoWiringOne au = (AutoWiringOne) ctx.getBean("autoWiringOne");
		au.autoWireTwoSpeak();

		//To AutoWire by type is the exact same thing, the only difference is changing the XML to "byType"
		//https://www.tutorialspoint.com/spring/spring_autowiring_bytype.htm

		//To AutoWire by Constructor is also the same, in the XML though you have to change the autowire to 'constructor'
		//and specify the default value https://www.tutorialspoint.com/spring/spring_autowiring_byconstructor.htm
	}

	public static void annotationRequiredConfiguration() {
		//Easier than using xml to describe your dependency relationships. It's performed before XML Injection, so XML
		//injection overrides annotation based configuration
		ApplicationContext ctx = new ClassPathXmlApplicationContext("RequiredBeanAutoConfig.xml");
		MyRequiredBean rc = (MyRequiredBean) ctx.getBean("myRequiredBean");
		System.out.println(rc.getRequired());
	}

	public static void annotationAutoWiredConfiguration() {
		//One can autowire based on constructor, property, or setter
		ApplicationContext ctx = new ClassPathXmlApplicationContext("MyAutowiredBean.xml");
		MyAutoWiredBeanOne rc = (MyAutoWiredBeanOne) ctx.getBean("MyAutoWiredBeanOne");
		System.out.println(rc.getMyVal());
	}
	public static void javaBasedConfiguration() {
		//Hate using XML? Well you don't have to! One can do all of it with Java

		//Two annotations to use: @Bean and @Configuration.
		//@Configuration will register your component with the Spring IoC Container as a source for beans.
		//@Bean put on a method informs the IoC that a method will return an object registered as a bean in the
		// application context

		//This is how you get the Bean
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfigOne.class);
		JavaConfigTwo jct = ctx.getBean(JavaConfigTwo.class);
		jct.setMessage("Hello World");
		jct.getMessage();

		//This is how you define the scope (Singleton, prototype) using Java Configuration
		DefiningScope.getBean();

		//Here is another way to import a Bean. Much easier
		ApplicationContext ctxTwo = new AnnotationConfigApplicationContext(ImportAnnotationOne.class);
		ctxTwo.getBean(ImportAnnotationOne.class);
		ctxTwo.getBean(ImportAnnotationTwo.class);
	}
}

