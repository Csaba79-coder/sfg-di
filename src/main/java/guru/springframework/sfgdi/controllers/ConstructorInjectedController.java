package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    // here @Autowired annotation is optional (developers with long term experience keep it, new ones does not annotate!
    // @Autowired

    // before Qualifier the greetingService in ConstructorInjectedController was underline with red!
    // after Qualifier we write the name of the class with lowercase letter at the beginning!
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
