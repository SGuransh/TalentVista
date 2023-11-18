package interface_adapter.showEmployees;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ShowEmployeesViewModel extends ViewModel {
    public final String TITLE_LABEL = "Employee View";

    private ShowEmployeesState state = new ShowEmployeesState();

    public static final String BACK_BUTTON_LABEL = "back";
    private String employees;

    public ShowEmployeesViewModel() {
        super("Employee Dashboard");
    }

    public void setState(ShowEmployeesState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ShowEmployeesState getState() {
        return state;
    }


    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {this.employees = employees;}

}
