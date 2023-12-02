package interface_adapter.hire_applicant;

import entity.Employee;
import use_case.HireApplicantButton.HireApplicantInputBoundary;
import use_case.HireApplicantButton.HireApplicantInputData;

public class HireApplicantController {
    final HireApplicantInputBoundary hireApplicantInteractor;

    public HireApplicantController(HireApplicantInputBoundary hireApplicantInteractor) {
        this.hireApplicantInteractor = hireApplicantInteractor;
    }
    public void execute(String name, String position, String email, Double salary){
        HireApplicantInputData inputData = new HireApplicantInputData(name, position, email, salary);
        hireApplicantInteractor.execute(inputData);
    }
}
