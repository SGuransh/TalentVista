package interface_adapter.deleteApplicants;

import use_case.deleteApplicants.deleteApplicantsInputBoundary;
import use_case.deleteApplicants.deleteApplicantsInputData;

import java.util.ArrayList;
import java.util.Arrays;

public class deleteApplicantsController {
    final deleteApplicantsInputBoundary deleteApplicantsInteractor;



    public deleteApplicantsController(deleteApplicantsInputBoundary deleteApplicantsInteractor) {
        this.deleteApplicantsInteractor = deleteApplicantsInteractor;
    }

    public void execute(String applicantIDs){
        String[] applicantSplit = applicantIDs.split(",");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(applicantSplit));
        deleteApplicantsInputData inputData = new deleteApplicantsInputData(stringList);
        deleteApplicantsInteractor.execute(inputData);
    }
}
