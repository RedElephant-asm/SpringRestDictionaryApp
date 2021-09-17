package org.SpringRestDictionaryApp.services;

import org.SpringRestDictionaryApp.ORM.entities.User;
import org.SpringRestDictionaryApp.repositories.UserRepository;
import org.SpringRestDictionaryApp.services.models.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends EntityService<User, UserRepository> {

    private static final User UNKNOWN_USER = new User(0, "UNKNOWN_USER.name", "UNKNOWN_USER.password");

    public UserService(@Autowired @Qualifier("userRepository") UserRepository mainRepository){
        super(mainRepository);
    }

    @Override
    public User getById(int id) {
        Optional<User> searchResult = super.mainRepository.findById(id);
        return searchResult.orElse(UNKNOWN_USER);
    }
}
