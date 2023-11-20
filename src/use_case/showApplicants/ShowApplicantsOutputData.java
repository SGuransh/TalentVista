package use_case.showApplicants;

public class ShowApplicantsOutputData {
    private final String presentableApplicants;

    public ShowApplicantsOutputData(String presentableApplicants) {this.presentableApplicants = presentableApplicants;}

    public String getPresentableApplicants(){return presentableApplicants;}
}
