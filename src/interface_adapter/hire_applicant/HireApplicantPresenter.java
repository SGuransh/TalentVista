package interface_adapter.hire_applicant;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageState;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import use_case.HireApplicantButton.HireApplicantOutputBoundary;
import use_case.HireApplicantButton.HireApplicantOutputData;

public class HireApplicantPresenter implements HireApplicantOutputBoundary {
    private final ShowHireApplicantPageViewModel showHireApplicantPageViewModel;
    private final HrDashboardViewModel hrDashboardViewModel;
    private ViewManagerModel viewManagerModel;

    public HireApplicantPresenter(ViewManagerModel viewManagerModel, ShowHireApplicantPageViewModel showHireApplicantPageViewModel, HrDashboardViewModel hrDashboardViewModel) {
        this.showHireApplicantPageViewModel = showHireApplicantPageViewModel;
        this.viewManagerModel = viewManagerModel;
        this.hrDashboardViewModel = hrDashboardViewModel;
    }

    @Override
    public void prepareSuccessView(HireApplicantOutputData outputData) {
        ShowHireApplicantPageState state = new ShowHireApplicantPageState();
        state.setEmployeeData(outputData.getEmployeeData());
        this.showHireApplicantPageViewModel.setState(state);
        showHireApplicantPageViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(hrDashboardViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
