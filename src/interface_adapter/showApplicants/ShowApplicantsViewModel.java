package interface_adapter.showApplicants;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ShowApplicantsViewModel extends ViewModel {
    public static final String TITLE = "Show Applicants Page";
    public static final String SHOW_HIRE_PAGE_BUTTON_LABEL = "Show Hire Page";
    public static final String APPLY_FILTERS_ON_APPLICANTS_BUTTON_LABEL = "Apply Filter";
    public static final String RESUME_PARSER_BUTTON_LABEL = "Resume Parser";
    public static final String DELETE_BUTTON_LABEL = "Delete";
    public static final String FILTER_BY_UPLOAD_DATE_LABEL = "Enter Date";
    public static final String FILTER_BY_SKILL_LABEL = "Enter the skill";
    public static final String DELETE_TEXT_LABEL = "Delete the following ids";
    public static final String HIRING_TEXT_LABEL = "Hire the applicant";
    public static final String UPLOAD_TEXT_LABEL = "File or directory of the resumes";
    public static final String UPLOAD_POSITION_LABEL = "Enter position";

    public static final String BACK_BUTTON_LABEL = "Back";

    public ShowApplicantsViewModel() {
        super("Show Applicants");
    }

    private ShowApplicantsState state = new ShowApplicantsState();

    public void setState(ShowApplicantsState state) {
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

    public ShowApplicantsState getState(){
        return this.state;
    }
}
