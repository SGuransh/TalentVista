package data_access;

import entity.Leave;
import entity.Project;
import entity.User;
import use_case.leave_request.LeaveRequestUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryLeaveRequestAccessObject implements LeaveRequestUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Project> projects = new HashMap<>();
    private final ArrayList<Leave> requests = new ArrayList<>();

    @Override
    public User getUser(String name) {
        return users.get(name);
    }

    @Override
    public Project getProject(String name) {
        return projects.get(name);
    }

    @Override
    public ArrayList<Leave> getRequests() {
        return requests;
    }

    @Override
    public void saveRequest(Leave request) {requests.add(request);}

    public void addUser(User user){users.put(user.getName(), user);}

    public void addProject(Project project){projects.put(project.getName(), project);}


}
