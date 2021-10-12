package guru.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// @Profile({"dog", "default"}) // --> when doing PetServiceFactory
// @Service // --> when doing PetServiceFactory // we use java config as it comes outside and not included in here!
public class DogPetService implements PetService {
    public String getPetType(){
        return "Dogs are the best!";
    }
}
