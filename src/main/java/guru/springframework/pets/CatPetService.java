package guru.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// @Service // --> when doing PetServiceFactory
// @Profile("cat") // --> when doing PetServiceFactory // we use java config as it comes outside and not included in here!
public class CatPetService implements PetService {
    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}