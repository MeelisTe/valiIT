package ee.bcs.valiit.controller;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectRowMapper3 implements RowMapper<CreditHistory> {

    @Override
    public CreditHistory mapRow(ResultSet resultSet, int i) throws SQLException {
        CreditHistory history = new CreditHistory(); // loome muutuja client
        history.setAmount(resultSet.getBigDecimal("amount"));
        history.setAccountFromId(resultSet.getBigDecimal("account_from_id"));
        history.setAccountToId(resultSet.getBigDecimal("account_to_id"));
        return history;
    }
}