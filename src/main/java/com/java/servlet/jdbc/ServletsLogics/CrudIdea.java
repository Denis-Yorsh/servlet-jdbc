package com.java.servlet.jdbc.ServletsLogics;

import com.java.servlet.jdbc.Pojo.PersonName;

public interface CrudIdea {

    public Integer create(PersonName personName);
    public PersonName readById(Integer id);
    public Integer update(PersonName personName);
    public Integer delete(Integer id);

}
