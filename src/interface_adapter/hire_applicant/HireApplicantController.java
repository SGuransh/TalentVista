package interface_adapter.hire_applicant;

import entity.Employee;
import use_case.HireApplicantButton.HireApplicantInputBoundary;
import use_case.HireApplicantButton.HireApplicantInputData;

public class HireApplicantController {
    final HireApplicantInputBoundary hireApplicantInteractor;

    public HireApplicantController(HireApplicantInputBoundary hireApplicantInteractor) {
        this.hireApplicantInteractor = hireApplicantInteractor;
    }
    public void execute(Employee employee){
        HireApplicantInputData inputData = new HireApplicantInputData(employee);
        hireApplicantInteractor.execute(inputData);
    }
}
