package com.example.a.finalproject;

/**
 * Created by A on 6/20/2016.
 */
public class Information {

    public Information(String title, String organization, String experience){
        this.title = title;
        this.organization = organization;
        this.experience = experience;
    }
    
    String title, organization, experience;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
