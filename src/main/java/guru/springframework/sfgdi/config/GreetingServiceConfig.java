package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.controllers.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.controllers.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.controllers.repositories.ItalianGreetingRepository;
import guru.springframework.sfgdi.controllers.repositories.ItalianGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean
    ItalianGreetingRepository italianGreetingRepository() {
        return new ItalianGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"IT", "default"})
    @Bean("i18nService") // this one here overwrites the name of the method!
    // @Qualifier("i18nService")
    // use behind @Bean or a separate @Qualifier!!!
    I18nItalianGreetingService i18nItalianGreetingService(ItalianGreetingRepository italianGreetingRepository) {
        return new I18nItalianGreetingService(italianGreetingRepository);
    }

//    // original method! change the name of the method to the one is found here:@Service("i18nService") in I18nEnglishGreetingService class!
//    @Bean
//    I18nEnglishGreetingService i18nEnglishGreetingService() {
//        return new I18nEnglishGreetingService();
//    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    // I can make @Qualifier to name my @Bean
    // by default, the name of the Bean is the name of the method, as follows: propertyInjectedGreetingService()
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
