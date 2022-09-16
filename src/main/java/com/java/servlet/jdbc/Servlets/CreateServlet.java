package com.java.servlet.jdbc.Servlets;

import com.java.servlet.jdbc.Pojo.PersonName;
import com.java.servlet.jdbc.ServletsDao.CrudLogics;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Function;

@WebServlet("/createServletJdbc")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PersonName personName = getPersonName(request);

        CrudLogics crudLogics = new CrudLogics();
        Function<PersonName, Integer> getGenerationId = crudLogics::create;
        Integer getId = getGenerationId.apply(personName);

        try {
            if (getId > 0) {
                out.println("Record saved successfully! Your ID = " + getId);
            } else {
                out.println("Sorry! unable to save record");
            }
        } finally {
            if (out != null) { out.close(); }
        }

    }

    private PersonName getPersonName(HttpServletRequest request) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        int intAge = Integer.parseInt(age);
        String country = request.getParameter("country");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        PersonName personName = new PersonName();
        personName.setFirstName(firstName);
        personName.setLastName(lastName);
        personName.setAge(intAge);
        personName.setCountry(country);
        personName.setPhone(phone);
        personName.setEmail(email);

        return personName;
    }
}
