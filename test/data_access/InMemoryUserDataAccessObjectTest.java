package data_access;

import entity.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryUserDataAccessObjectTest {

    @Test
    void successTest() {
        InMemoryUserDataAccessObject dao = new InMemoryUserDataAccessObject();
        assert dao.existsByName("talentvista26@gmail.com");
        assert dao.existsByName("admin");
        assertEquals(dao.get("admin"), "admin");
        assertEquals(dao.get("talentvista26@gmail.com"), "tvista#26");
    }
}