package use_case.showEmployees;

public class ShowEmployeesInteractor implements ShowEmployeesInputBoundary{
    final ShowEmployeesDataAccessInterface userDataAccessObject;
    final ShowEmployeesOutputBoundary showEmployeesPresenter;

    public ShowEmployeesInteractor(ShowEmployeesDataAccessInterface userDataAccessObject, ShowEmployeesOutputBoundary showEmployeesPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.showEmployeesPresenter = showEmployeesPresenter;
    }

    @Override
    public void execute() {
        System.out.println("Employees");
        String employees = userDataAccessObject.getPresentableEmployees();
        ShowEmployeesOutputData outputData = new ShowEmployeesOutputData(employees);
        showEmployeesPresenter.prepareSuccessView(outputData);
    }
}
