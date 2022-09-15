package com.java.servlet.jdbc.ServletsDao;

import java.util.Map;

public class GetRequestToSql {

    public static String baseDataSqlRequest(String request) {

        Map<String, String> baseDataRequest = Map.of(
                "CreatePreparedNameSql", "INSERT INTO person_name(first_name, last_name,age) values (?,?,?) ",
                "CreatePreparedAdminSql","INSERT INTO admin_info(dates, pk_uk) values (?,?)",
                "CreatePreparedInfoSql","INSERT INTO person_info(country, phone,email, fk_uk) values (?,?,?,?)",
                "DeletePreparedSql","DELETE FROM person_name WHERE id_pk = ?"
        );
        return baseDataRequest.get(request);
    }
}
