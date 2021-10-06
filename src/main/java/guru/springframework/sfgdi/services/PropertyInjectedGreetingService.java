package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service // if we do not clear with @Qualifier we get a message it confused which one IntelliJ suppose to use!
// go to ConstructorInjectedController to make Qualifier!!!
public class PropertyInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }
}
