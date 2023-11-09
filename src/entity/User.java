package entity;

import java.time.LocalDateTime;

public interface User {

    String getName();

    String getPassword();

    LocalDateTime getCreationTime();

    Integer getLevel();
    // 1. SuperUser
    // 2. HR
    // 3. Employee
}
