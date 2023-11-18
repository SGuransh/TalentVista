package use_case.HireApplicant;

import entity.Employee;

public class HireApplicantInteractor implements HireApplicantInputBoundary{
    final HireApplicantDataAccessInterface EmployeeDataAccessObject;

    public HireApplicantInteractor(HireApplicantDataAccessInterface employeeDataAccessObject) {
        EmployeeDataAccessObject = employeeDataAccessObject;
    }

    @Override
    public void execute(HireApplicantInputData inputData) {
        EmployeeDataAccessObject.addEmployee(inputData.getEmployee());
    }
}
