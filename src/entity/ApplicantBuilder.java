package entity;

import org.json.JSONObject;

public interface ApplicantBuilder {
    public void buildApplicantName(JSONObject data);
    public void buildApplicantId(Integer id, JSONObject data);
    public void buildApplicantSkills(JSONObject data);
    public void buildApplicantPersonalUrls(JSONObject data);
    public void buildApplicantUploadDate();
    public void buildApplicantContactInfo(JSONObject data);
    public void buildApplicantPosition(String position);
    public Applicant getApplicant_();
}
