package ee.bcs.valiit.controller;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectRowMapper implements RowMapper<BankAccount> {

    @Override
    public BankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
        BankAccount accounts = new BankAccount(); // loome muutuja accounts
        accounts.setAccountNr(resultSet.getString("account_nr")); //''account_nr'' nimetus(väärtus) tuleb Postgre'st account tabelist. getString - võtame account nr'i väärtuse. resultSet anname ''accounts.setAccountNr'' accountNr'le väärtuse, ''accounts.setAccountNr'' annab väärtuse klassi BankAccount ''account_Nr'' muutujale
        accounts.setAmount(resultSet.getBigDecimal("balance"));
        return accounts;
    }
}
