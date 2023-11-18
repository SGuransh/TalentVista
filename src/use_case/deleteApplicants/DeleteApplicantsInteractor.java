package use_case.deleteApplicants;

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
        DeleteApplicantsOutputData outputData = new DeleteApplicantsOutputData(applicantsDataAccessObject.getPresentableApplicants());
        applicantsPresenter.prepareSuccessView(outputData);
    }
}
