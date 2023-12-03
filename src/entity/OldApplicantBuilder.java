package entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class OldApplicantBuilder implements ApplicantBuilder {
    private Applicant applicant;

    public OldApplicantBuilder(){
        this.applicant = new Applicant();
    }

    @Override
    public void buildApplicantName(JSONObject data) {
        String name;
        try {
            name = new JSONObject(data.get("name").toString()).getString("full_name");   // response.data.name.full_name
        } catch (JSONException e) {
            name = "Not Found";
        }
        applicant.setName(name);
    }

    @Override
    public void buildApplicantId(Integer id, JSONObject data) {
        String last_name;
        try {
            last_name = new JSONObject(data.get("name").toString()).getString("last_name");   // response.data.name.last_name
        } catch (JSONException last_name_e) {
            last_name = "Not Found";
        }
        String idString = last_name + "00" + (id + 1);
        applicant.setId(idString);
    }

    @Override
    public void buildApplicantSkills(JSONObject data) {
        ArrayList<String> skills;
        try {
            skills = new ArrayList<String>();
            JSONArray overallSkills = new JSONObject(data.get("skills").toString()).getJSONArray("overall_skills");
            for (int i = 0; i < overallSkills.length(); i++) {
                skills.add(overallSkills.getString(i));
            }
        } catch (JSONException skills_e) {
            skills = new ArrayList<String>();
        }
        applicant.setSkills(skills);
    }

    @Override
    public void buildApplicantPersonalUrls(JSONObject data) {
        ArrayList<String> urls;
        try {
            String personal_urls = data.getString("personal_urls");
            urls = new ArrayList<String>();
            personal_urls = personal_urls.replace("]", "");
            personal_urls = personal_urls.replace("[", "");
            personal_urls = personal_urls.replace("\"", "");
            String[] elements = personal_urls.split(",");
            for (String element : elements) {
                element.replace(" ", "");
                urls.add(element);
            }
        } catch (JSONException personal_urls_e) {
            urls = new ArrayList<String>();
        }
        applicant.setPersonal_urls(urls);
    }

    @Override
    public void buildApplicantUploadDate() {
        applicant.setUploadDate();
    }

    @Override
    public void buildApplicantContactInfo(JSONObject data) {
        HashMap<String, String> contactInfo;
        try {
            contactInfo = new HashMap<>();
            String email = data.get("email").toString();
            email = email.replace("]", "");
            email = email.replace("[", "");
            email = email.replace("\"", "");
            email = email.replace("{", "");
            email = email.replace("}", "");
            email = email.replace("email:", "");
            String phone = data.get("phone").toString();
            phone = phone.replace("]", "");
            phone = phone.replace("[", "");
            phone = phone.replace("\"", "");
            phone = phone.replace("{", "");
            phone = phone.replace("}", "");
            phone = phone.replace("phone:", "");
            contactInfo.put("email", email);
            contactInfo.put("phone", phone);
        } catch (JSONException contact_info_e) {
            contactInfo = new HashMap<>();
        }
        applicant.setContactInfo(contactInfo);
    }

    @Override
    public void buildApplicantPosition(String position) {
        applicant.setPosition(position);
    }

    @Override
    public Applicant getApplicant_() {
        return applicant;
    }
}
