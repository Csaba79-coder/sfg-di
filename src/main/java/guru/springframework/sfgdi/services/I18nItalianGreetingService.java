package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// if there is no active profile set, we want default the italian one!
// if you comment out with # the profile (EN) in application.properties look what's going on?! --> there comes the italian greeting :)
// conclusion if you do not set default value in @Profile you need to set something in application.properties!!!

@Profile({"IT", "default"})
@Service("i18nService")
public class I18nItalianGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Ciao Mondo! - IT";
    }
}
