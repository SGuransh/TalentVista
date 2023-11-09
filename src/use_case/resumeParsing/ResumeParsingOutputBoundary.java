package use_case.resumeParsing;

import use_case.login.LoginOutputData;

public interface ResumeParsingOutputBoundary {
    void prepareSuccessView(ResumeParsingOutputData applicantData);

    void prepareFailView(String error);
}
