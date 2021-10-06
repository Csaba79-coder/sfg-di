package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		// bean name is always the nem of the class, but with lowercase letter!

		// when I run the project I receive the method's sout ...
		// this one makes the instances for me! ...
		// I do not create an instance! Spring provides me ...!!!
		// this one casts my String to Object (object type is the class name!) i.e. MyController!
		MyController myController = (MyController) ctx.getBean("myController");

		// this includes the return value - in return and makes the sout!!!
		// and the sout inside, but will print the sout only!!!
		// as far as we did not do anything with return value (it is just in memory!)
		String greeting = myController.sayHello();

		// here I sout the return value! the return value must be separate sout!!!
		System.out.println(greeting);


		System.out.println("\n--------Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		// This error down bellow was the reason I had not annotated the PropertyInjectedController with @Controller annotation! let's do it now!

//		Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'propertyInjectedController' available
//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanDefinition(DefaultListableBeanFactory.java:805)
//		at org.springframework.beans.factory.support.AbstractBeanFactory.getMergedLocalBeanDefinition(AbstractBeanFactory.java:1278)
//		at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:297)
//		at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
//		at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1108)
//		at guru.springframework.sfgdi.SfgDiApplication.main(SfgDiApplication.java:34)

		// after annotation of PropertyInjectedController's class ... get another error message as follows:

//		Exception in thread "main" java.lang.NullPointerException: Cannot invoke "guru.springframework.sfgdi.services.GreetingService.sayGreeting()" because "this.greetingService" is null
//		at guru.springframework.sfgdi.controllers.PropertyInjectedController.getGreeting(PropertyInjectedController.java:12)
//		at guru.springframework.sfgdi.SfgDiApplication.main(SfgDiApplication.java:46)

		// solution:
		// make the greeting service autowired! still problem is exists as follows (the prob. is shown by IntelliJ with red underline!):

//		Action:
//
//		Consider defining a bean of type 'guru.springframework.sfgdi.services.GreetingService' in your configuration.

		System.out.println(propertyInjectedController.getGreeting());
		System.out.println("\n----------Setter");


		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("\n-----Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("\n----Primary Bean");
		MyPrimaryController myPrimaryController = (MyPrimaryController) ctx.getBean("myPrimaryController");
		String primaryGreeting = myPrimaryController.sayHello();
		System.out.println(primaryGreeting);
 	}
}
