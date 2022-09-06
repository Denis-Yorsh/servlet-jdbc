package com.java.servlet.jdbc.Pojo;

import java.util.Date;

public class PersonName extends AdminInfo {

    private Integer personId;
    private String firstName;
    private String lastName;
    private Integer age;

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

    @Override
    public String toString() {
        return "Person Name [" +
                "personId=" + personId +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", age=" + age +
                "]";
    }
}
