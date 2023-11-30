package use_case.HireApplicantButton;

import entity.Employee;

public class HireApplicantInputData {
    private final String name;
    private final String 

    public HireApplicantInputData(Employee employee) {
        this.employee = employee;

    }

    Employee getEmployee(){
        return this.employee;
    }
}
