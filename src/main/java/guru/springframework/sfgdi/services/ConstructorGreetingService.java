package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

// previous name before refactor was GreetingServiceImp

// @Service
// @Component
// @Controller
public class ConstructorGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - Constructor";
    }
}
