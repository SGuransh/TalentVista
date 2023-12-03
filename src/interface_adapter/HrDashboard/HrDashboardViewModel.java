package interface_adapter.HrDashboard;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HrDashboardViewModel extends ViewModel {
    public static final String SHOW_APPLICANTS_BUTTON_LABEL = "Show Applicants";
    public static final String SHOW_EMPLOYEES_BUTTON_LABEL = "Show Employees";

    public static final String TITLE_LABEL = "HR DASHBOARD";


    public HrDashboardViewModel() {
        super("HR Dashboard");
    }


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {}

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);}
}
