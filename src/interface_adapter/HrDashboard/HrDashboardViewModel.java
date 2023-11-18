package interface_adapter.HrDashboard;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HrDashboardViewModel extends ViewModel {
    public static final String SHOW_APPLICANTS_BUTTON_LABEL = "Show Applicants";
    public static final String SHOW_EMPLOYEES_BUTTON_LABEL = "Show Employees";

    public static final String TITLE_LABEL = "HR DASHBOARD";

    private HrDashboardState state = new HrDashboardState();

    public HrDashboardViewModel() {
        super("sign up");
    }

    public void setState(HrDashboardState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public HrDashboardState getState() {
        return this.state;
    }
}
