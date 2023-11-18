package interface_adapter.deleteApplicants;

import use_case.deleteApplicants.DeleteApplicantsInputBoundary;
import use_case.deleteApplicants.DeleteApplicantsInputData;

import java.util.ArrayList;
import java.util.Arrays;

public class DeleteApplicantsController {
    final DeleteApplicantsInputBoundary deleteApplicantsInteractor;



    public DeleteApplicantsController(DeleteApplicantsInputBoundary deleteApplicantsInteractor) {
        this.deleteApplicantsInteractor = deleteApplicantsInteractor;
    }

    public void execute(String applicantIDs){
        String[] applicantSplit = applicantIDs.split(",");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(applicantSplit));
        DeleteApplicantsInputData inputData = new DeleteApplicantsInputData(stringList);
        deleteApplicantsInteractor.execute(inputData);
    }
}
