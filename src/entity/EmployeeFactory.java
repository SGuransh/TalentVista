package entity;

import java.time.LocalDateTime;

public class EmployeeFactory {
    /**
     * Requires: password is valid.
     * @param name
     * @param password
     * @return
     */

    public Employee create(String name, String password, LocalDateTime ltd, Double salary, String position) {return new Employee(name, password, ltd, salary, position);}
}
