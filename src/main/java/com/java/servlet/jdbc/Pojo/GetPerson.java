package com.java.servlet.jdbc.Pojo;

public class GetPerson extends PersonInfo {

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
        return "Get Person [" +
                "personId = " + personId +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", age = " + age +
                "]";
    }
}
