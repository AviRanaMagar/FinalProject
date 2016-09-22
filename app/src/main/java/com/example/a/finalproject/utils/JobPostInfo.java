package com.example.a.finalproject.utils;

/**
 * Created by A on 8/31/2016.
 */
public class JobPostInfo {


    String jobTitle,companyName,expiryDate;

    public JobPostInfo(String jobTitle, String companyName, String expiryDate) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.expiryDate = expiryDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

//    public void setJobTitle(String jobTitle) {
//        this.jobTitle = jobTitle;
//    }

    public String getCompanyName() {
        return companyName;
    }

//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }

    public String getExpiryDate() {
        return expiryDate;
    }

//    public void setExpiryDate(String expiryDate) {
//        this.expiryDate = expiryDate;
//    }

}
