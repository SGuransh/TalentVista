package use_case.leave_request;

import entity.Leave;

public class LeaveRequestOutputData {
    private final Leave request;

    public LeaveRequestOutputData(Leave request) {
        this.request = request;
    }
    public Leave getRequest(){return request;}
}
