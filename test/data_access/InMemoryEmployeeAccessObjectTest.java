package data_access;

import entity.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryEmployeeAccessObjectTest {
    @Test
    void successTest(){
        InMemoryEmployeeAccessObject DAO = new InMemoryEmployeeAccessObject();
        Employee employee = new Employee("Shahbaz", null, null, 100.0, null, null);
        DAO.addEmployee(employee);
        InMemoryEmployeeAccessObject DAO2 = new InMemoryEmployeeAccessObject();
        assert!(DAO2.existsEmployee("Shahbaz"));
        DAO2.ReadCsvToInMemory();
        assert(DAO2.existsEmployee("Shahbaz"));
    }

}