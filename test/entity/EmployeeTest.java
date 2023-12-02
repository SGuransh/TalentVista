package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    private Employee employee;

    @BeforeEach
    void init() {
       String name = "shahbaz";
       String password = null;
       LocalDateTime time = null;
       Double salary = 100.0;
       String position = "Developer";
       String email = "shahbaz@gmail.com";

        employee = new Employee(name, password, time, salary, position, email);
    }

    @Test
    void getNameTest() {
        assertEquals("shahbaz", employee.getName());
    }

    @Test
    void getPasswordTest() {
        assertEquals(null, employee.getPassword());
    }

    @Test
    void getTimeTest() {
        assertEquals(null, employee.getCreationTime());
    }

    @Test
    void getSalaryTest() {
        assertEquals(100.0, employee.getSalary());
    }

    @Test
    void getPositionTest() {
        assertEquals("Developer", employee.getPosition());
    }

    @Test
    void getEmailTest() {
        assertEquals("shahbaz@gmail.com", employee.getEmail());
    }

    @Test
    void EmployeeFactoryTest(){
        String name = "shahbaz";
        String password = null;
        LocalDateTime time = null;
        Double salary = 100.0;
        String position = "Developer";
        String email = "shahbaz@gmail.com";
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee1 = employeeFactory.create(name, password, time, salary, position, email);
        assertEquals("shahbaz", employee1.getName());
        assertEquals(null, employee1.getPassword());
        assertEquals(null, employee1.getCreationTime());
        assertEquals(100.0, employee1.getSalary());
        assertEquals("Developer", employee1.getPosition());
        assertEquals("shahbaz@gmail.com", employee1.getEmail());



    }

}
