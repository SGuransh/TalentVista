package interface_adapter.leave_request;

import use_case.leave_request.LeaveRequestInputBoundary;
import use_case.leave_request.LeaveRequestInputData;

public class LeaveRequestController {
    final LeaveRequestInputBoundary leaveRequestInteractor;

    public LeaveRequestController(LeaveRequestInputBoundary interactor) {
        leaveRequestInteractor = interactor;
    }
    public void execute(String name, String startDate, String endDate, String reason, String projectName){
        LeaveRequestInputData inputData = new LeaveRequestInputData(name, startDate, endDate, reason, projectName);
        leaveRequestInteractor.execute(inputData);
    }
}
