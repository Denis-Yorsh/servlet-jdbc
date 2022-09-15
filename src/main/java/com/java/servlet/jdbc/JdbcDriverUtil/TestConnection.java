package com.java.servlet.jdbc.JdbcDriverUtil;

import com.java.servlet.jdbc.Pojo.PersonName;
import com.java.servlet.jdbc.ServletsDao.CrudLogics;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection connection = GetConnection.getConnection();
        CrudLogics crudLogics = new CrudLogics();

        PersonName personName = new PersonName();
        personName.setFirstName("Sasha");
        personName.setLastName("Petrov");
        personName.setAge(25);
        personName.setCountry("Ney York");
        personName.setPhone("0(34)-33-45-615");
        personName.setEmail("po01pov@yahoo.com");

//        Integer create = crudLogics.create(personName);
//        System.out.println(create);

        Integer delete = crudLogics.delete(34);
        System.out.println(delete);
    }
}
