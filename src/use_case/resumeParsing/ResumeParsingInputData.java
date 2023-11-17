package use_case.resumeParsing;

public class ResumeParsingInputData {
    private final String path;

    public ResumeParsingInputData(String path) {
        this.path = path;
    }

    String getPath(){return path;}
}
