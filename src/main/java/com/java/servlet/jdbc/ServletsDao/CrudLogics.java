package com.java.servlet.jdbc.ServletsDao;

import com.java.servlet.jdbc.JdbcDriverUtil.GetConnection;
import com.java.servlet.jdbc.Pojo.PersonName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.UnaryOperator;

public class CrudLogics implements CrudIdea {

    private static final UnaryOperator<String> getSqlRequest = GetRequestToSql::baseDataSqlRequest;

    @Override
    public Integer create(PersonName personName) {

        Connection connection = null;
        int status = 0;

        try {
            connection = GetConnection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedName = connection.prepareStatement
                    (getSqlRequest.apply("CreatePreparedNameSql"), PreparedStatement.RETURN_GENERATED_KEYS);
            preparedName.setString(1, personName.getFirstName());
            preparedName.setString(2, personName.getLastName());
            preparedName.setInt(3, personName.getAge());
            status += preparedName.executeUpdate();

            long generationId = fetchGeneratedId(preparedName);

            java.util.Date dateJava = new java.util.Date();
            java.sql.Date dateSql = new java.sql.Date(dateJava.getTime());
            PreparedStatement preparedAdmin = connection.prepareStatement
                    (getSqlRequest.apply("CreatePreparedAdminSql"));
            preparedAdmin.setDate(1, dateSql);
            preparedAdmin.setInt(2, (int) generationId);
            status += preparedAdmin.executeUpdate();

            PreparedStatement preparedInfo = connection.prepareStatement
                    (getSqlRequest.apply("CreatePreparedInfoSql"));
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

        PersonName personName = new PersonName();

        try (Connection connection = GetConnection.getConnection()){

            PreparedStatement preparedRead = connection.prepareStatement
                    (getSqlRequest.apply("ReadPreparedSql"));
            preparedRead.setInt(1, id);
            ResultSet resultSet = preparedRead.executeQuery();

            if (resultSet.next()) {
                personName.setPersonId(resultSet.getInt("id_pk"));
                personName.setFirstName(resultSet.getString("first_name"));
                personName.setLastName(resultSet.getString("last_name"));
                personName.setAge(resultSet.getInt("age"));
                personName.setCountry(resultSet.getString("country"));
                personName.setPhone(resultSet.getString("phone"));
                personName.setEmail(resultSet.getString("email"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personName;
    }

    @Override
    public Integer update(PersonName personName) {

        Connection connection = null;
        int status = 0;

        try {
            connection = GetConnection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedName = connection.prepareStatement
                    (getSqlRequest.apply("UpdatePreparedNameSql"));
            preparedName.setString(1, personName.getFirstName());
            preparedName.setString(2, personName.getLastName());
            preparedName.setInt(3, personName.getAge());
            preparedName.setInt(4, personName.getPersonId());
            status += preparedName.executeUpdate();

            PreparedStatement preparedInfo = connection.prepareStatement
                    (getSqlRequest.apply("UpdatePreparedInfoSql"));
            preparedInfo.setString(1, personName.getCountry());
            preparedInfo.setString(2, personName.getPhone());
            preparedInfo.setString(3, personName.getEmail());
            preparedInfo.setInt(4, personName.getPersonId());
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

    @Override
    public Integer delete(Integer id) {

        int status = 0;

        try (Connection connection = GetConnection.getConnection()){

            PreparedStatement preparedDelete = connection.prepareStatement
                    (getSqlRequest.apply("DeletePreparedSql"));
            preparedDelete.setInt(1, id);
            status = preparedDelete.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}
