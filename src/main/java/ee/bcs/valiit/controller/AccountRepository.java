package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void createAccountUUS(BigDecimal clientId, String accountNr, BigDecimal balance) {
        String sql = "INSERT INTO account(client_id, account_nr, balance) VALUES(:client_id, :account_nr, :balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("client_id", clientId);
        paramMap.put("account_nr", accountNr);
        paramMap.put("balance", balance);
        jdbcTemplate.update(sql, paramMap);
    }

    public String getAccount(String accountNr) {
        String sql = "SELECT account_nr FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_nr", accountNr);
        String vastus = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return vastus;
    }

    public void depositMoney(String accountNr, BigDecimal amount) {
        String sql = "UPDATE account SET balance = balance + :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("balance", amount);
        paramMap.put("account_nr", accountNr);
        jdbcTemplate.update(sql, paramMap);
    }


    public BigDecimal getAccountBalance(String accountNr, BigDecimal amount) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_nr", accountNr);
        BigDecimal accountbalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class); // nt. BigDecimal accountbalance = new BigDecimal(val: "10");
        return accountbalance;
    }


    public void withdrawMoney(String accountNr, BigDecimal amount) {
        String sql2 = "UPDATE account SET balance = balance - :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("balance", amount);
        paramMap.put("account_nr", accountNr);
        jdbcTemplate.update(sql2, paramMap);
    }

    public void transferMoney(String accountNr1, String accountNr2, BigDecimal amount) {
        String sql2 = "UPDATE account SET balance = balance - :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("balance", amount);
        paramMap.put("account_nr", accountNr1);
        jdbcTemplate.update(sql2, paramMap);

        String sql3 = "UPDATE account SET balance = balance + :balance WHERE account_nr = :account_nr";
        paramMap.put("balance", amount);
        paramMap.put("account_nr", accountNr2);
        jdbcTemplate.update(sql3, paramMap);
    }


    public List<BankAccount> allAccounts() {
        String sql = "SELECT * FROM account"; //select * - võtame kõik väärtused antud List'ist
        return jdbcTemplate.query(sql, new HashMap(), new ObjectRowMapper());
    }

    public void createClient(String firstName, String lastName) {
        String sql = "INSERT INTO client(first_name, last_name) values(:first_name, :last_name)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("first_name", firstName);
        paramMap.put("last_name", lastName);
        jdbcTemplate.update(sql, paramMap);

    }

    public void depositHistory(BigDecimal account_to_id, BigDecimal amount, String accountNr) {
        String sql = "UPDATE account SET balance = balance + :balance WHERE account_nr = :account_nr";
        String sql1 = "INSERT INTO credit_history WHERE account_to_id = :account_to_id";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_to_id", account_to_id);
        paramMap.put("balance", amount);
        paramMap.put("account_nr", accountNr);
        jdbcTemplate.update(sql, paramMap);
        jdbcTemplate.query(sql1, new HashMap(), new ObjectRowMapper());
    }
}



