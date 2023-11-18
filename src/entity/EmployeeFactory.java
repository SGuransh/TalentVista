package entity;

import java.time.LocalDateTime;

public class EmployeeFactory implements UserFactory {
    /**
     * Requires: password is valid.
     * @param name
     * @param password
     * @return
     */

    @Override
    public User create(String name, String password, LocalDateTime ltd) {return new Employee(name, password, ltd);}
}
