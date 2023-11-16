package use_case.deleteApplicants;

public class deleteApplicantsInteractor implements deleteApplicantsInputBoundary{

    final deleteApplicantsDataAccessInterface applicantsDataAccessObject;

    final deleteApplicantsOutputBoundary applicantsPresenter;

    public deleteApplicantsInteractor(deleteApplicantsDataAccessInterface applicantsDataAccessObject, deleteApplicantsOutputBoundary applicantsPresenter) {
        this.applicantsDataAccessObject = applicantsDataAccessObject;
        this.applicantsPresenter = applicantsPresenter;
    }

    @Override
    public void execute(deleteApplicantsInputData inputData) {
        applicantsDataAccessObject.deleteApplicants(inputData.getApplicantIDs());
        deleteApplicantsOutputData outputData = new deleteApplicantsOutputData(applicantsDataAccessObject.getApplicants());
        applicantsPresenter.prepareSuccessView(outputData);
    }
}
