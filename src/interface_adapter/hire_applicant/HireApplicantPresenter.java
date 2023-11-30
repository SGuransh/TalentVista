package interface_adapter.hire_applicant;

import interface_adapter.ViewManagerModel;
import use_case.HireApplicantButton.HireApplicantOutputBoundary;
import use_case.HireApplicantButton.HireApplicantOutputData;

public class HireApplicantPresenter implements HireApplicantOutputBoundary {
    private final HireApplicantViewModel hireApplicantViewModel;
    private ViewManagerModel viewManagerModel;

    public HireApplicantPresenter(HireApplicantViewModel hireApplicantViewModel, ViewManagerModel viewManagerModel) {
        this.hireApplicantViewModel = hireApplicantViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(HireApplicantOutputData outputData) {

    }
}
