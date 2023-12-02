package data_access;

import entity.User;
import use_case.login.LoginUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements LoginUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();
    /**
     * @param identifier the user's username
     * @return whether the user exists
     */
    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public User get(String username) {
        return null;
    }
}

