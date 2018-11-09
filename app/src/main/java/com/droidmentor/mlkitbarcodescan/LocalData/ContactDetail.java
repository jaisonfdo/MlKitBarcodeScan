package com.droidmentor.mlkitbarcodescan.LocalData;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Jaison.
 */
public class ContactDetail
{
    @DatabaseField(generatedId=true)
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String address;
    @DatabaseField
    private String emailID;
    @DatabaseField
    private String phoneNumber;
    @DatabaseField
    private String orgName;
    @DatabaseField
    private String webLink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
