package entity;

import java.time.LocalDateTime;

public class Employee implements User {

    private final String name;
    private final String password;
    private final LocalDateTime creationTime;
    private final Integer level = 3;

    private final Double salary;

    private final String position;

    private final String email;

    /**
     * Requires: password is valid.
     *
     * @param name
     * @param password
     * @param salary
     * @param position
     * @param email
     */
    Employee(String name, String password, LocalDateTime creationTime, Double salary, String position, String email) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
        this.salary = salary;
        this.position = position;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public Integer getLevel() {return level;}
}
