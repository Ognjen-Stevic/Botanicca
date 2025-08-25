package it355.ognjenstevic5378.eshop.repository;

import it355.ognjenstevic5378.eshop.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;

@Repository
@ApplicationScope
public class InMemoryUserRepository {
    private final ArrayList<User> users = new ArrayList<>();

    public InMemoryUserRepository() {
    }

    @PostConstruct
    private void initializer() {
        users.add(new User(1L, "Anastasija", "Anastasija"));
        users.add(new User(2L, "Ognjen", "Ognjen"));
    }

    public void addNewUser(User u) {
        this.users.add(u);
    }

    public ArrayList<User> getAllUsers() {
        return this.users;
    }

    public Long getLastID() {
        return this.users.get(users.size() - 1).getId();
    }

    public void changeUser(User newUser) {
        this.users.stream()
                .filter(user -> user.getId().equals(newUser.getId()))
                .findFirst()
                .ifPresent(user -> {
                    user.setPassword(newUser.getPassword());
                    user.setUsername(newUser.getUsername());
                });
    }
}
