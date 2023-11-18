package use_case.leave_request;

import entity.Leave;
import entity.Project;
import entity.User;

import java.util.ArrayList;

public interface LeaveRequestUserDataAccessInterface {
    User getUser(String name);
    Project getProject(String name);
    ArrayList<Leave> getRequests();
    void saveRequest(Leave request);
    void addUser(User user);
    void addProject(Project project);

}
