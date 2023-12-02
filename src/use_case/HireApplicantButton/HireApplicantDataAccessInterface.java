package use_case.HireApplicantButton;

import entity.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public interface HireApplicantDataAccessInterface {
    void addEmployee(Employee employee);
    String getEmployeeData(Employee employee);
    void clearCSV();
}
