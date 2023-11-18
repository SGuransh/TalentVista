package use_case.deleteApplicants;
import java.util.ArrayList;

public class DeleteApplicantsInputData {
    private final ArrayList<String> applicantIDs;

    public DeleteApplicantsInputData(ArrayList<String> applicantIDs) {
        this.applicantIDs = applicantIDs;
    }

    ArrayList<String> getApplicantIDs() {
        return this.applicantIDs;
    }
}
