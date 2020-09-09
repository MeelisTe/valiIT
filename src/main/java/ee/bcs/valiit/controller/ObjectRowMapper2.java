package ee.bcs.valiit.controller;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectRowMapper2 implements RowMapper<CreateClient> {

    @Override
    public CreateClient mapRow(ResultSet resultSet, int i) throws SQLException {
        CreateClient client = new CreateClient(); // loome muutuja client
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        return client;
    }
}

