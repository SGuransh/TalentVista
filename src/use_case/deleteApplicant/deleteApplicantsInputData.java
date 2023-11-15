package use_case.deleteApplicant;
import java.util.ArrayList;

public class deleteApplicantsInputData {
    private final ArrayList<String> applicantIDs;

    public deleteApplicantsInputData(ArrayList<String> applicantIDs) {
        this.applicantIDs = applicantIDs;
    }

    ArrayList<String> getApplicantIDs() {
        return this.applicantIDs;
    }
}
