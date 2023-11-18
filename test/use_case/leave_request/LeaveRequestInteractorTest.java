package use_case.leave_request;

import data_access.InMemoryLeaveRequestAccessObject;
import entity.EmployeeFactory;
import entity.Leave;
import entity.Project;
import entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LeaveRequestInteractorTest {

    @Test
    void successTest() {
        LeaveRequestInputData inputData = new LeaveRequestInputData("Paul", "01/01/2023",
                "02/01/2023", "medical emergency", "Alpha");
        LeaveRequestUserDataAccessInterface userRepository = new InMemoryLeaveRequestAccessObject();
        EmployeeFactory employeeFactory = new EmployeeFactory();
        User employee = employeeFactory.create("Paul", "password", LocalDateTime.now());
        Project project = new Project( "Alpha", new ArrayList<>());
        project.addMember(employee);
        userRepository.addUser(employee);
        userRepository.addProject(project);
        LeaveRequestOutputBoundary successPresenter = new LeaveRequestOutputBoundary() {
            @Override
            public void prepareSuccessView(LeaveRequestOutputData outputData) {
                Leave request = outputData.getRequest();
                assertEquals("Paul", request.getEmployee().getName());
                assertEquals("01/01/2023", request.getStartDate());
                assertEquals("02/01/2023", request.getEndDate());
                assertEquals("medical emergency", request.getReason());
                assertEquals("Alpha", request.getProject().getName());
                assertTrue(userRepository.getRequests().contains(request));
            }

        };

        LeaveRequestInputBoundary interactor = new LeaveRequestInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }
}