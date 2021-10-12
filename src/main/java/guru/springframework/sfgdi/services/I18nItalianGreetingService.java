package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.repositories.ItalianGreetingRepository;

// if there is no active profile set, we want default the italian one!
// if you comment out with # the profile (EN) in application.properties look what's going on?! --> there comes the italian greeting :)
// conclusion if you do not set default value in @Profile you need to set something in application.properties!!!

// @Profile({"IT", "default"}) // after creating config!
// @Service("i18nService") // after creating config!
public class I18nItalianGreetingService implements GreetingService {

    private final ItalianGreetingRepository italianGreetingRepository;

    public I18nItalianGreetingService(ItalianGreetingRepository italianGreetingRepository) {
        this.italianGreetingRepository = italianGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Ciao Mondo! - IT";
    }
}
