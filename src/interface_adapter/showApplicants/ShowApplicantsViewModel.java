package interface_adapter.showApplicants;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class ShowApplicantsViewModel extends ViewModel {

    public ShowApplicantsViewModel() {
        super("Show Applicants");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
