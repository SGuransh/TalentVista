package data_access;

import entity.Applicant;
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
    public String getEmployeeData(Employee employee){
        StringBuilder employeeData = new StringBuilder();
        String name = employee.getName();
        Double salary = employee.getSalary();
        String position = employee.getPosition();
        String email = employee.getEmail();
        employeeData.append(" NAME: " + name + ", SALARY: " + salary + ", EMAIL: " + email + ", POSITION: " + position);
        return employeeData.toString();
    }

    @Override
    public String getPresentableEmployees() {
        StringBuilder presentableEmployees = new StringBuilder();
        for (String employeeName: employees.keySet()){
            Employee employee = employees.get(employeeName);
            String name = employee.getName();
            Double salary = employee.getSalary();
            String position = employee.getPosition();
            String email = employee.getEmail();
            presentableEmployees.append(" NAME: " + name + ", SALARY: " + salary + ", EMAIL: " + email + ", POSITION: " + position);
            presentableEmployees.append("\n\n");
        }
        return presentableEmployees.toString();
    }

}
