package guru.springframework.sfgdi.config;

import guru.springframework.pets.DogPetService;
import guru.springframework.pets.PetService;
import guru.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.repositories.ItalianGreetingRepository;
import guru.springframework.sfgdi.repositories.ItalianGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    // watch out the curly braces!!!
    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
                                  @Value("${guru.password}") String password,
                                  @Value("${guru.jdbcUrl}") String jdbcUrl) {

        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean("petService")
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }


    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

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

    // @Bean // --> as it is defined in the config.xml!!!
    // but also in this case you dont need the method itself as well!!!
//    ConstructorGreetingService constructorGreetingService() {
//        return new ConstructorGreetingService();
//    }

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
