package use_case.filter;

public interface FilterOutputBoundary {
    void prepareSuccessView(FilterOutputData outputData);
    void prepareFailView(String error);
}
