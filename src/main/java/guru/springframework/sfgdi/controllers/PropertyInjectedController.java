package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Qualifier("propertyInjectedGreetingService")
    @Autowired
    public GreetingService greetingService;

    // if we have the @Controller and @Autowired annotation the problem still exists, greetingService is underline with red ...
    // reason: there is no instance of greetingService!!! ...
    // solution add to: public class GreetingServiceImpl implements GreetingService @Service annotation to the class, so Spring makes instance for us!

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
