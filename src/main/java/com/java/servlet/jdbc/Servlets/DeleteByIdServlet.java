package com.java.servlet.jdbc.Servlets;

import com.java.servlet.jdbc.ServletsDao.CrudLogics;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.UnaryOperator;

@WebServlet("/deleteServletJdbc")
public class DeleteByIdServlet extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {

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
        UnaryOperator<Integer> deleteById = crudLogics::delete;
        Integer getStatus = deleteById.apply(getId);

        try {
            if (getStatus == 0) {
                out.print(
                        "This user with ID " + getId +
                        " can't be deleted.\nThis user with ID " + getId +
                        " is does not exist");
            } else {
                out.print("This user is DELETED\n");
            }
        } finally {
            out.close();
        }
    }
}
