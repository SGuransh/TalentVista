package use_case.showEmployees;

import entity.Employee;

public interface ShowEmployeesDataAccessInterface {
    void addEmployee(Employee employee);
    String getPresentableEmployees();
}
