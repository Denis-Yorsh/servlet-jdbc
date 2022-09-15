package com.java.servlet.jdbc.ServletsDao;

import java.util.Map;

public class GetRequestToSql {

    public static String baseDataSqlRequest(String request) {

        Map<String, String> baseDataRequest = Map.of(
                "CreatePreparedNameSql",
                "INSERT INTO person_name(first_name, last_name,age) values (?,?,?) ",

                "CreatePreparedAdminSql",
                "INSERT INTO admin_info(dates, pk_uk) values (?,?)",

                "CreatePreparedInfoSql",
                "INSERT INTO person_info(country, phone,email, fk_uk) values (?,?,?,?)",

                "DeletePreparedSql","DELETE FROM person_name WHERE id_pk = ?",

                "ReadPreparedSql","" +
                        "SELECT * FROM person_name " +
                        "INNER JOIN person_info " +
                        "ON person_name.id_pk = person_info.fk_uk " +
                        "WHERE person_name.id_pk = ?",

                "UpdatePreparedNameSql",
                "UPDATE person_name SET first_name = ?,last_name = ?,age = ? WHERE id_pk = ?",

                "UpdatePreparedInfoSql",
                "UPDATE person_info SET country = ?,phone = ?,email = ? WHERE fk_uk = ?"
        );
        return baseDataRequest.get(request);
    }
}
