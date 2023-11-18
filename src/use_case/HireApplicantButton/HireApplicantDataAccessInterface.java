package use_case.HireApplicantButton;

import entity.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public interface HireApplicantDataAccessInterface {
    public void addEmployee(Employee employee);
    public HashMap<String, ArrayList<String>> getEmployees();
}
