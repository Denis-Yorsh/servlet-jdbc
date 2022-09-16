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

@WebServlet("/updateServletJdbc")
public class UpdateByIdServlet extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String id = request.getParameter("id");
        Integer getId = Integer.parseInt(id);
        PersonName personName = getPersonName(request, getId);

        CrudLogics crudLogics = new CrudLogics();
        Function<PersonName, Integer> updateById = crudLogics::update;
        Integer getStatus = updateById.apply(personName);

        try {
            if (getStatus > 0) {
                try {
                    response.sendRedirect("readServletJdbc?id=" + getId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                out.println("Sorry! unable to update record");
            }
        } finally {
            if (out != null) { out.close(); }
        }
    }

    private PersonName getPersonName(HttpServletRequest request, Integer getId) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        int intAge = Integer.parseInt(age);
        String country = request.getParameter("country");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        PersonName personName = new PersonName();
        personName.setPersonId(getId);
        personName.setFirstName(firstName);
        personName.setLastName(lastName);
        personName.setAge(intAge);
        personName.setCountry(country);
        personName.setPhone(phone);
        personName.setEmail(email);

        return personName;
    }
}
