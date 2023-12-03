package use_case.login;

import entity.User;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    String get(String username);
}
