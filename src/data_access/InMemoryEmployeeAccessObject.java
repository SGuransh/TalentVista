package data_access;

import entity.Employee;
import use_case.HireApplicantButton.HireApplicantDataAccessInterface;
import use_case.showEmployees.ShowEmployeesDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryEmployeeAccessObject implements HireApplicantDataAccessInterface, ShowEmployeesDataAccessInterface {

        private final Map<String, Employee> employees = new HashMap<String, Employee>();

    public Boolean existsApplicant(String id) {
        return employees.containsKey(id);
    }
    @Override
    public void addEmployee(Employee employee) {
        if (existsApplicant(employee.getName())) {
            return;
        }
        employees.put(employee.getName(), employee);
    }

    @Override
    public HashMap<String, ArrayList<String>> getEmployees() {
        return null;
    }



    @Override
    public String getPresentableEmployees() {
        return "hello";
    }
}
