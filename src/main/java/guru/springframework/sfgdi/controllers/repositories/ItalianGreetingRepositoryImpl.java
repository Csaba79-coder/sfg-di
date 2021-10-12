package guru.springframework.sfgdi.controllers.repositories;

public class ItalianGreetingRepositoryImpl implements ItalianGreetingRepository {
    @Override
    public String getGreeting() {
        return "Ciao Mondo! - IT";
    }
}
