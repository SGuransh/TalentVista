package use_case.resumeParsing;

public class ResumeParsingInputData {
    private final String dirPath;

    public ResumeParsingInputData(String dirPath) {
        this.dirPath = dirPath;
    }

    String getFilepath(){return dirPath;}
}
