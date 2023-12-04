package use_case.deleteApplicants;

import java.util.ArrayList;
import java.util.Objects;

public class DeleteApplicantsInteractor implements DeleteApplicantsInputBoundary {

    final DeleteApplicantsDataAccessInterface applicantsDataAccessObject;

    final DeleteApplicantsOutputBoundary applicantsPresenter;

    public DeleteApplicantsInteractor(DeleteApplicantsDataAccessInterface applicantsDataAccessObject, DeleteApplicantsOutputBoundary applicantsPresenter) {
        this.applicantsDataAccessObject = applicantsDataAccessObject;
        this.applicantsPresenter = applicantsPresenter;
    }

    @Override
    public void execute(DeleteApplicantsInputData inputData) {
        applicantsDataAccessObject.deleteApplicants(inputData.getApplicantIDs());
        String recentlyDeleted = "";
        if (!inputData.getApplicantIDs().isEmpty() && !inputData.getApplicantIDs().get(0).isEmpty()){
            recentlyDeleted += "The Following are deleted:\n";
            for (String id : inputData.getApplicantIDs()) {
                recentlyDeleted += id + "\n";
            }
        }
        DeleteApplicantsOutputData outputData = new DeleteApplicantsOutputData(applicantsDataAccessObject.getPresentableApplicants(), recentlyDeleted);
        applicantsPresenter.prepareSuccessView(outputData);
    }
}
