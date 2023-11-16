package entity;

import java.time.LocalDateTime;

public class Employee implements User {

    private final String name;
    private final String password;
    private final LocalDateTime creationTime;
    private final Integer level = 3;

    private final Double salary;

    private final String position;

    /**
     * Requires: password is valid.
     *
     * @param name
     * @param password
     * @param salary
     * @param position
     */
    Employee(String name, String password, LocalDateTime creationTime, Double salary, String position) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
        this.salary = salary;
        this.position = position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public Integer getLevel() {return level;}
}
