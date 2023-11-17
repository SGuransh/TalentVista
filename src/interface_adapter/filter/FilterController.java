package interface_adapter.filter;

import use_case.filter.FilterInputBoundary;
import use_case.filter.FilterInputData;

public class FilterController {
    final FilterInputBoundary filterUseCaseInteractor;

    public FilterController(FilterInputBoundary filterUseCaseInteractor) {
        this.filterUseCaseInteractor = filterUseCaseInteractor;
    }
    public void execute(String skill, String uploadDate){
        FilterInputData inputData = new FilterInputData(skill, uploadDate);
        filterUseCaseInteractor.execute(inputData);
    }
}
