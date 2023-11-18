package use_case.leave_request;

import entity.Leave;
import entity.Project;
import entity.User;

public class LeaveRequestInteractor implements LeaveRequestInputBoundary{
    final LeaveRequestUserDataAccessInterface userDataAccessObject;
    final LeaveRequestOutputBoundary presenter;

    public LeaveRequestInteractor(LeaveRequestUserDataAccessInterface userDataAccessObject, LeaveRequestOutputBoundary presenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(LeaveRequestInputData inputData) {
        User user = userDataAccessObject.getUser(inputData.getName());
        Project project = userDataAccessObject.getProject(inputData.getProjectName());
        Leave request = new Leave(user, inputData.getStartDate(), inputData.getEndDate(), inputData.getReason(),
                project);
        userDataAccessObject.saveRequest(request);
        LeaveRequestOutputData outputData = new LeaveRequestOutputData(request);
        presenter.prepareSuccessView(outputData);
    }
}
