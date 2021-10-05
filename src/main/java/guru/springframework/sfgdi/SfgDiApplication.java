package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.MyController;
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
	}

}
