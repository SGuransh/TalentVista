package interface_adapter.back;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import use_case.back.BackOutputBoundary;

public class BackPresenter implements BackOutputBoundary {
    private final HrDashboardViewModel hrDashboardViewModel;
    private ViewManagerModel viewManagerModel;

    public BackPresenter(HrDashboardViewModel hrDashboardViewModel, ViewManagerModel viewManagerModel) {
        this.hrDashboardViewModel = hrDashboardViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        System.out.println("t");
        this.viewManagerModel.setActiveView(hrDashboardViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
