package com.java.servlet.jdbc.Pojo;

public class PersonInfo {

    private Integer infoId;
    private String country;
    private String phone;
    private String email;

    public Integer getInfoId() {
        return infoId;
    }
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
