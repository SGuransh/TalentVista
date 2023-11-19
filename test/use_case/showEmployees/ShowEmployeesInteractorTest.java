package use_case.showEmployees;

import data_access.InMemoryEmployeeAccessObject;
import data_access.InMemoryLeaveRequestAccessObject;
import entity.Employee;
import entity.EmployeeFactory;
import entity.Leave;
import entity.Project;
import org.junit.jupiter.api.Test;
import use_case.leave_request.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShowEmployeesInteractorTest {

    @Test
    void successTest() {
        ShowEmployeesDataAccessInterface userRepository = new InMemoryEmployeeAccessObject();
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee = employeeFactory.create("Paul", "password", LocalDateTime.now(), 500.00, "Dev", "p@gmail.com");
        userRepository.addEmployee(employee);
        Employee employee2 = employeeFactory.create("John", "password", LocalDateTime.now(), 120.00, "Manager", "j@gmail.com");
        userRepository.addEmployee(employee2);
        ShowEmployeesOutputBoundary successPresenter = new ShowEmployeesOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowEmployeesOutputData outputData) {
                String employees = outputData.getEmployees();
                System.out.println(employees);
                assertEquals(" NAME: John, SALARY: 120.0, EMAIL: j@gmail.com, POSITION: Manager\n\n NAME: Paul, SALARY: 500.0, EMAIL: p@gmail.com, POSITION: Dev\n\n", employees);
            }

        };

        ShowEmployeesInputBoundary interactor = new ShowEmployeesInteractor(userRepository, successPresenter);
        interactor.execute();
    }
}