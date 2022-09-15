package com.java.servlet.jdbc.ServletsDao;

import com.java.servlet.jdbc.JdbcDriverUtil.GetConnection;
import com.java.servlet.jdbc.Pojo.PersonName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudLogics implements CrudIdea {

    @Override
    public Integer create(PersonName personName) {

        Connection connection = null;
        int status = 0;

        try {
            connection = GetConnection.getConnection();
            connection.setAutoCommit(false);

            String preparedNameSql = "INSERT into person_name(first_name, last_name,age) values (?,?,?) ";
            String preparedAdminSql = "INSERT into admin_info(dates, pk_uk) values (?,?)";
            String preparedInfoSql = "INSERT into person_info(country, phone,email, fk_uk) values (?,?,?,?)";


            PreparedStatement preparedName = connection.prepareStatement
                    (preparedNameSql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedName.setString(1, personName.getFirstName());
            preparedName.setString(2, personName.getLastName());
            preparedName.setInt(3, personName.getAge());
            status += preparedName.executeUpdate();

            long generationId = fetchGeneratedId(preparedName);
            System.out.println(generationId);


            java.util.Date dateJava = new java.util.Date();
            java.sql.Date dateSql = new java.sql.Date(dateJava.getTime());
            PreparedStatement preparedAdmin = connection.prepareStatement
                    (preparedAdminSql);
            preparedAdmin.setDate(1, dateSql);
            preparedAdmin.setInt(2, (int) generationId);
            status += preparedAdmin.executeUpdate();

            PreparedStatement preparedInfo = connection.prepareStatement
                    (preparedInfoSql);
            preparedInfo.setString(1, personName.getCountry());
            preparedInfo.setString(2, personName.getPhone());
            preparedInfo.setString(3, personName.getEmail());
            preparedInfo.setInt(4, (int) generationId);
            status += preparedInfo.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return status;
    }

    private static long fetchGeneratedId(PreparedStatement insertStatement) throws SQLException {
        ResultSet generatedKeys = insertStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            return generatedKeys.getLong(1);
        } else {
            // ДОБАВИЛЬ ВЫВОД СООБЩЕНИЯ В ЛОГИ
            throw new NullPointerException();
        }
    }

    @Override
    public PersonName readById(Integer id) {
        return null;
    }

    @Override
    public Integer update(PersonName personName) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        Connection connection = null;
        int status = 0;
        String preparedDeleteSql = "DELETE from person_name WHERE id_pk = ?";

        try {
            connection = GetConnection.getConnection();
            PreparedStatement preparedDelete = connection.prepareStatement(preparedDeleteSql);
            preparedDelete.setInt(1, id);
            status = preparedDelete.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return status;
    }
}
