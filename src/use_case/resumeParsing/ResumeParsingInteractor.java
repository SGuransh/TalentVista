package use_case.resumeParsing;

import entity.Applicant;
import entity.ApplicantFactory;

import java.io.File;
import java.util.ArrayList;

public class ResumeParsingInteractor implements ResumeParsingInputBoundary {
    private final ResumeParsingDataAccessInterface inMemoryApplicantAccessObject;
    private final ResumeParsingOutputBoundary presenter;
    private final ApplicantFactory applicantFactory;

    public ResumeParsingInteractor(ResumeParsingDataAccessInterface inMemoryApplicantAccessObject, ResumeParsingOutputBoundary resumeParsingPresenter, ApplicantFactory applicantFactory) {
        this.inMemoryApplicantAccessObject = inMemoryApplicantAccessObject;
        this.presenter = resumeParsingPresenter;
        this.applicantFactory = applicantFactory;
    }

    @Override
    public void execute(ResumeParsingInputData inputData) {
        System.out.println("Called");
        String position = inputData.getPosition();
        String filepathString = inputData.getPath();
        ArrayList<Applicant> applicants = new ArrayList<>();
        try {
            if (isPDFFile(filepathString)) {
                System.out.println("PDF seen");
                int last_number = inMemoryApplicantAccessObject.getId();
                Applicant applicant = applicantFactory.makeApplicantFromString(filepathString, last_number, position);
                inMemoryApplicantAccessObject.addApplicant(applicant);
                applicants.add(applicant);
            }
            else if (isDirectory(filepathString)) {
                System.out.println("dir seen");
                File folder = new File(filepathString);
                File[] listOfFiles = folder.listFiles();
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        String filePath = file.getAbsolutePath();
                        if (isPDFFile(filePath)) {
                            int last_number = inMemoryApplicantAccessObject.getId();
                            Applicant applicant = applicantFactory.makeApplicantFromString(filePath, last_number, position);
                            inMemoryApplicantAccessObject.addApplicant(applicant);
                            applicants.add(applicant);
                            System.out.println(applicant);
                        }
                    }
                }
            }
            else{
                System.out.println("FAILLLLLL");
            }
        }catch (Exception e){
            System.out.println("here");
            System.out.println("Error: " + e.getMessage());
            // TODO: handle exception in the presenter
        }

        String presenterString = inMemoryApplicantAccessObject.getPresentableApplicants();
        ResumeParsingOutputData outputData = new ResumeParsingOutputData(presenterString);
//        ResumeParsingOutputData outputData = new ResumeParsingOutputData(applicants);
        presenter.prepareSuccessView(outputData);
    }

    private static boolean isPDFFile(String filePath) {
        String lowerCaseFilePath = filePath.toLowerCase();

        return lowerCaseFilePath.endsWith(".pdf");
    }

    private static boolean isDirectory(String filePath) {
        File file = new File(filePath);

        return file.isDirectory();
    }
}
