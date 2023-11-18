package interface_adapter.ResumeParsing;

import use_case.resumeParsing.ResumeParsingInputBoundary;
import use_case.resumeParsing.ResumeParsingInputData;

public class ResumeParsingController {

    final ResumeParsingInputBoundary resumeParsingInteractor;

    public ResumeParsingController(ResumeParsingInputBoundary resumeParsingInteractor) {
        this.resumeParsingInteractor = resumeParsingInteractor;
    }

    public void execute(String path, String position){
        ResumeParsingInputData inputData = new ResumeParsingInputData(path, position);
        resumeParsingInteractor.execute(inputData);
    }
}
