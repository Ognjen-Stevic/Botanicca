package it355.ognjenstevic5378.eshop.service;

import it355.ognjenstevic5378.eshop.model.User;
import it355.ognjenstevic5378.eshop.repository.InMemoryUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static it355.ognjenstevic5378.eshop.util.Util.getNewID;

@Service
public class UserService {
    private final InMemoryUserRepository inMemoryUserRepository;

    public UserService(InMemoryUserRepository inMemoryUserRepository) {
        this.inMemoryUserRepository = inMemoryUserRepository;
    }

    public Optional<User> login(String username, String password) {
        return inMemoryUserRepository.getAllUsers().stream().filter(user -> (user.getPassword().equals(password) && user.getUsername().equals(username))).findFirst();
    }

    public void registerNewUser(String username, String password) {
        inMemoryUserRepository.addNewUser(new User(getNewID(inMemoryUserRepository.getLastID()),username,password));
    }

    public void changeUser(User newUser){
        inMemoryUserRepository.changeUser(newUser);
    }
}
