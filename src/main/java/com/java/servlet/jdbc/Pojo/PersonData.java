package com.java.servlet.jdbc.Pojo;

import java.util.Date;

public class PersonData {

    private Integer personId;
    private String firstName;
    private String lastName;
    private Integer age;
    private PersonInfo personInfo;
    private Date date;
    private Integer count;
    private Boolean isDelete;

    public PersonData() {
    }

    public PersonData(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public PersonData(String firstName, String lastName, Integer age, PersonInfo personInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.personInfo = personInfo;
    }

    public Integer getPersonId() {
        return personId;
    }
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }
    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
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
        return "Person Data [personId = " + personId +
                ", First Name = " + firstName +
                ", Last Name = " + lastName +
                ", age = " + age +
                ", personInfo = " + personInfo +
                ", date = " + date +
                ", count = " + count +
                ", isDelete = " + isDelete + "]";
    }
}
