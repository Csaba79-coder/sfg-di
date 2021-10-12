package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// @Primary // I do not need it because of config! -> after making in config, remove!
// @Service // I do not need it because of config! -> after making in config, remove!
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - from the Primary Bean";
    }
}
