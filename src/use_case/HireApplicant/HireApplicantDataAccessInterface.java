package use_case.HireApplicant;

import entity.Applicant;
import entity.Employee;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public interface HireApplicantDataAccessInterface {
    public void addEmployee(Employee employee);
    public HashMap<String, ArrayList<String>> getEmployees();
}
