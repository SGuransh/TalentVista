package use_case.resumeParsing;

public class ResumeParsingInputData {
    private final String path;

    private final String position;

    public ResumeParsingInputData(String path, String position) {
        this.path = path;
        this.position = position;
    }

    String getPath(){return path;}

    String getPosition(){return position;}
}
