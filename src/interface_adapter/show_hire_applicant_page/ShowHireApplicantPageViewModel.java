package interface_adapter.show_hire_applicant_page;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ShowHireApplicantPageViewModel extends ViewModel {
    public final String TITLE_LABEL = "Hire Applicant View";
    public final String NAME_LABEL = "Enter name";
    public final String POSITION_LABEL = "Enter position";
    public final String EMAIL_LABEL = "Enter email";
    public final String Salary_Label = "Enter Salary";

    public static final String HIRE_BUTTON_LABEL = "Hire";

    private ShowHireApplicantPageState state = new ShowHireApplicantPageState();

    public ShowHireApplicantPageViewModel() {
        super("Hire Applicant");
    }

    public void setState(ShowHireApplicantPageState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ShowHireApplicantPageState getState() {
        return state;
    }
}
