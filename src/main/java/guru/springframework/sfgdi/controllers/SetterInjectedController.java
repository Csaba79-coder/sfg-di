package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    @Autowired
    // this means we want a greeting service injection in this bean!
    public void setGreetingService(@Qualifier("setterInjectedGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }
//
//    @Qualifier(value = "setterInjectedGreetingService")
//    @Autowired
//    // this means we want a greeting service injection in this bean!
//    public void setGreetingService(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
