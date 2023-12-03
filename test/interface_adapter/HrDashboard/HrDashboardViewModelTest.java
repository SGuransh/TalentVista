package interface_adapter.HrDashboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HrDashboardViewModelTest {

    @Test
    void successTest() {
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        hrDashboardViewModel.firePropertyChanged();
        hrDashboardViewModel.addPropertyChangeListener(null);
    }

}