package ee.bcs.valiit.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectRowMapper4 implements RowMapper<Transfer> {

    @Override
    public Transfer mapRow(ResultSet resultSet, int i) throws SQLException {
        Transfer transfer = new Transfer(); // loome muutuja transfer
        transfer.setAmount(resultSet.getBigDecimal("amount")); //''account_nr'' nimetus(väärtus) tuleb Postgre'st account tabelist. getString - võtame account nr'i väärtuse. resultSet anname ''accounts.setAccountNr'' accountNr'le väärtuse, ''accounts.setAccountNr'' annab väärtuse klassi BankAccount ''account_Nr'' muutujale
        transfer.setAccountFromId(resultSet.getBigDecimal("account_from_id"));
        transfer.setAccountToId(resultSet.getBigDecimal("account_to_id"));
        return transfer;
    }
}