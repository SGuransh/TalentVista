package use_case.resumeParsing;

public interface ResumeParsingOutputBoundary {
    void prepareSuccessView(ResumeParsingOutputData applicantData);
    void prepareFailView(String error);
}
