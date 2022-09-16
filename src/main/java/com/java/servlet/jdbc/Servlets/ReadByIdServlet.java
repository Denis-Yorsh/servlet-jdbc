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

@WebServlet("/readServletJdbc")
public class ReadByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

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

        CrudLogics crudLogics = new CrudLogics();
        Function<Integer, PersonName> getPersonNameById = crudLogics::readById;
        PersonName personName = getPersonNameById.apply(getId);

        try {
            out.print("Person Name [\nperson Id = " + personName.getPersonId() +
                    ", \nfirstName = " + personName.getFirstName() +
                    ", \nlastName = " + personName.getLastName() +
                    ", \nage = " + personName.getAge() +
                    ", \ncountry = " + personName.getCountry() +
                    ", \nphone = " + personName.getPhone() +
                    ", \nemail = " + personName.getEmail() + "\n]");
        } finally {
            if (out != null) { out.close(); }
        }
    }
}
