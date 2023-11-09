package use_case.resumeParsing;

import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import use_case.login.LoginUserDataAccessInterface;

public class ResumeParsingInteractor implements ResumeParsingInputBoundary{
    ResumeParsingDataAccessInterface ResumeParsingDataAccessObject;
    ResumeParsingOutputBoundary ResumeParsingPresenter;

    LoginOutputBoundary FakeResumeParsingPresenter = new ResumeParsingOutputBoundary() {
        @Override
        public void prepareSuccessView(ResumeParsingOutputData data) {
            // Write the success Data to a file
            ...
        }

        @Override
        public void prepareFailView(String error) {
            ...
        }
    };

    public ResumeParsingInteractor(ResumeParsingDataAccessInterface ResumeParsingDataAccessObject, ResumeParsingOutputBoundary ResumeParsingPresenter) {
        this.ResumeParsingDataAccessObject = ResumeParsingDataAccessObject;
        this.ResumeParsingPresenter = ResumeParsingPresenter;
    }

    @Override
    public void execute(ResumeParsingInputData inputData) {
        // The input to the interactor is the path to the directory which has the pdfs

    }
}
