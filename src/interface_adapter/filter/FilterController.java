package interface_adapter.filter;

import use_case.filter.FilterInputBoundary;
import use_case.filter.FilterInputData;

public class FilterController {
    final FilterInputBoundary filterUseCaseInteractor;

    public FilterController(FilterInputBoundary filterUseCaseInteractor) {
        this.filterUseCaseInteractor = filterUseCaseInteractor;
    }
    public void execute(String uploadDate, String skill){
        FilterInputData inputData = new FilterInputData(uploadDate, skill);
        filterUseCaseInteractor.execute(inputData);
    }
}
