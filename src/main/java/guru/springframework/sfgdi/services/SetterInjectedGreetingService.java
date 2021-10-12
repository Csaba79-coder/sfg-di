package guru.springframework.sfgdi.services;

import org.springframework.beans.factory.annotation.Qualifier;

// @Service
public class SetterInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - Setter";
    }
}
