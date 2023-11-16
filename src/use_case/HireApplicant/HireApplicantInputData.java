package use_case.HireApplicant;

import entity.Employee;

public class HireApplicantInputData {
    private final Employee employee;

    public HireApplicantInputData(Employee employee) {
        this.employee = employee;

    }

    Employee getEmployee(){
        return this.employee;
    }
}
