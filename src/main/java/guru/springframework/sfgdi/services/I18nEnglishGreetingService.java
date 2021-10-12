package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.controllers.repositories.EnglishGreetingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// do not forget to add active profile in resources folder to application.properties
// @Profile("EN") // remove after config!
// @Service("i18nService") // remove after config!
public class I18nEnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
