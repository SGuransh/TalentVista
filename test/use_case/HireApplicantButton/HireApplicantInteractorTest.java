package use_case.HireApplicantButton;

import data_access.InMemoryEmployeeAccessObject;
import interface_adapter.hire_applicant.HireApplicantPresenter;
import org.junit.jupiter.api.Test;
import use_case.resumeParsing.ResumeParsingInteractor;

import static org.junit.jupiter.api.Assertions.*;

class HireApplicantInteractorTest {

    @Test
    void successHiringFakeEmail() {
        HireApplicantInputData inputData = new HireApplicantInputData("Guransh Singh", "Dev", "testing.gmail.com", 5005.0);
        HireApplicantDataAccessInterface dataAccessObject = new InMemoryEmployeeAccessObject();
        dataAccessObject.clearCSV();

        HireApplicantOutputBoundary fakePresenter = new HireApplicantOutputBoundary() {
            @Override
            public void prepareSuccessView(HireApplicantOutputData outputData) {
                String EmployeeViewingString = outputData.getEmployeeData();
                assertEquals(" NAME: Guransh Singh, SALARY: 5005.0, EMAIL: testing.gmail.com, POSITION: Dev".trim(), EmployeeViewingString.trim());
            }
        };

        AutoMailSend mailSender = new AutoMailSend();
        HireApplicantInteractor interactor = new HireApplicantInteractor(dataAccessObject, mailSender, fakePresenter);
        interactor.execute(inputData);
        dataAccessObject.clearCSV();
    }

    @Test
    void successHiringTrueEmail() {
        HireApplicantInputData inputData = new HireApplicantInputData("Shahbaz Singh", "Dev", "ayush22ar@gmail.com", 5005.0);
        HireApplicantDataAccessInterface dataAccessObject = new InMemoryEmployeeAccessObject();
        dataAccessObject.clearCSV();

        HireApplicantOutputBoundary fakePresenter = new HireApplicantOutputBoundary() {
            @Override
            public void prepareSuccessView(HireApplicantOutputData outputData) {
                String EmployeeViewingString = outputData.getEmployeeData();
                assertEquals(" NAME: Shahbaz Singh, SALARY: 5005.0, EMAIL: ayush22ar@gmail.com, POSITION: Dev".trim(), EmployeeViewingString.trim());
            }
        };

        AutoMailSend mailSender = new AutoMailSend();
        HireApplicantInteractor interactor = new HireApplicantInteractor(dataAccessObject, mailSender, fakePresenter);
        interactor.execute(inputData);
        dataAccessObject.clearCSV();
    }
}