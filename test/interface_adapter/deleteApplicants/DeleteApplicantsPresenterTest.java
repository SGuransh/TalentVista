package interface_adapter.deleteApplicants;

import data_access.InMemoryApplicantAccessObject;
import entity.Applicant;
import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import org.junit.jupiter.api.Test;
import use_case.deleteApplicants.DeleteApplicantsOutputBoundary;
import use_case.deleteApplicants.DeleteApplicantsOutputData;

import java.util.ArrayList;
import java.util.HashMap;

class DeleteApplicantsPresenterTest {

    @Test
    void successTest() {
        Applicant applicant;
        InMemoryApplicantAccessObject applicantsDAO = new InMemoryApplicantAccessObject();
        applicantsDAO.clearCSV();
        ArrayList<String> skills = new ArrayList<String>();
        skills.add("python");
        skills.add("java");
        skills.add("machine learning");
        skills.add("kotlin");
        HashMap<String, String> contactInfo = new HashMap<>();
        contactInfo.put("email", "guransh.hotmail.com");
        contactInfo.put("phone", "9998887776");
        ArrayList<String> personal_urls = new ArrayList<>();
        personal_urls.add("linkedin.com");
        personal_urls.add("github.com");
        applicant = new Applicant("Singh025", "Guransh Singh", skills, "2023-12-01", contactInfo, personal_urls, "dev");
        Applicant applicant2 = new Applicant("100", "Shahbaz", skills,"2023-12-01", contactInfo, personal_urls, "dev" );
        applicantsDAO.addApplicant(applicant);
        applicantsDAO.addApplicant(applicant2);

        String presentableApplicants = applicantsDAO.getPresentableApplicants();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShowApplicantsViewModel showApplicantsViewModel = new ShowApplicantsViewModel();
        String recentlyDeleted = "";
        DeleteApplicantsOutputData outputData = new DeleteApplicantsOutputData(presentableApplicants, recentlyDeleted);

        DeleteApplicantsOutputBoundary presenter = new DeleteApplicantsPresenter(viewManagerModel, showApplicantsViewModel);
        presenter.prepareSuccessView(outputData);
        assert(showApplicantsViewModel.getState().getApplicantsToDisplay().contains("Guransh Singh"));
        assert(showApplicantsViewModel.getState().getApplicantsToDisplay().contains("Shahbaz"));
        applicantsDAO.clearCSV();
    }
}