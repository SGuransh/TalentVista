package entity;

import java.time.LocalDateTime;

class SuperUser implements User {

    private final String name;
    private final String password;
    private final LocalDateTime creationTime;
    private final Integer level = 1;

    /**
     * Requires: password is valid.
     * @param name
     * @param password
     */
    SuperUser(String name, String password, LocalDateTime creationTime) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
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
