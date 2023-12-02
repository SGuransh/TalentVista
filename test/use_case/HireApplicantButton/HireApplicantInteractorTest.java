package use_case.HireApplicantButton;

import data_access.InMemoryEmployeeAccessObject;
import interface_adapter.hire_applicant.HireApplicantPresenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HireApplicantInteractorTest {

    @Test
    void successHiring() {
        HireApplicantInputData inputData = new HireApplicantInputData("Guransh Singh", "Dev", "testing.gmail.com", 5005.0);
        HireApplicantDataAccessInterface dataAccessObject = new InMemoryEmployeeAccessObject();
        dataAccessObject.clearCSV();

        HireApplicantOutputBoundary fakePresenter = new HireApplicantOutputBoundary() {
            @Override
            public void prepareSuccessView(HireApplicantOutputData outputData) {

            }
        };


    }
}