package com.java.servlet.jdbc.Pojo;

import java.util.Date;

public class AdminInfo extends PersonInfo {

    private Integer adminId;
    private Date date;
    private Integer count;
    private Boolean isDelete;

    public AdminInfo() {
    }
    public AdminInfo(Integer infoId, String country, String phone, String email,
                     Integer adminId, Date date, Integer count, Boolean isDelete) {
        super(infoId, country, phone, email);
        this.adminId = adminId;
        this.date = date;
        this.count = count;
        this.isDelete = isDelete;
    }

    public Integer getAdminId() {
        return adminId;
    }
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getDelete() {
        return isDelete;
    }
    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "Admin Info [" +
                "adminId = " + adminId +
                ", date = " + date +
                ", count = " + count +
                ", isDelete = " + isDelete +
                "]";
    }
}
