package use_case.showEmployees;

public class ShowEmployeesInteractor implements ShowEmployeesInputBoundary{
    final ShowEmployeesUserDataAccessInterface userDataAccessObject;
    final ShowEmployeesOutputBoundary showEmployeesPresenter;

    public ShowEmployeesInteractor(ShowEmployeesUserDataAccessInterface userDataAccessObject, ShowEmployeesOutputBoundary showEmployeesPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.showEmployeesPresenter = showEmployeesPresenter;
    }

    @Override
    public void execute() {
        String employees = userDataAccessObject.getPresentableEmployees();
        ShowEmployeesOutputData outputData = new ShowEmployeesOutputData(employees);
        showEmployeesPresenter.prepareSuccessView(outputData);
    }
}
