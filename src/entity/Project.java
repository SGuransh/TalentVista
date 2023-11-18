package entity;

import java.util.ArrayList;

public class Project {
    private final String name;
    private ArrayList<User> members;

    public Project(String name, ArrayList<User> members){
        this.name = name;
        this.members = members;
    }
    public String getName(){return name;}
    public ArrayList<User> getMembers(){return members;}

    public Boolean isMember(User member){return members.contains(member);}
    public void addMember(User member){members.add(member);}
}
