package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
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


    public BigDecimal getAccountBalance(String accountNr) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_nr", accountNr);
        BigDecimal accountbalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class); // nt. BigDecimal accountbalance = new BigDecimal(val: "10");
        return accountbalance;
    }


    public void depositMoney(String accountNr2, BigDecimal amount) {
        String sql = "UPDATE account SET balance = balance + :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("balance", amount);
        paramMap.put("account_nr", accountNr2);
        jdbcTemplate.update(sql, paramMap);
    }


    public void withdrawMoney(String accountNr1, BigDecimal amount) {
        String sql2 = "UPDATE account SET balance = balance - :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("balance", amount);
        paramMap.put("account_nr", accountNr1);
        jdbcTemplate.update(sql2, paramMap);
    }


    public List<BankAccount> allAccounts() {
        String sql = "SELECT * FROM account"; //select * - võtame kõik väärtused antud List'ist
        return jdbcTemplate.query(sql, new HashMap(), new ObjectRowMapper());
    }

    public List<CreateClient> allClients() {
        String sql = "SELECT * FROM client"; //select * - võtame kõik väärtused antud List'ist
        return jdbcTemplate.query(sql, new HashMap(), new ObjectRowMapper2());
    }

    public List<CreditHistory> allCreditHistory() {
        String sql = "SELECT * FROM credit_history"; //select * - võtame kõik väärtused antud List'ist
        return jdbcTemplate.query(sql, new HashMap(), new ObjectRowMapper3());
    }

    public void createClient(String firstName, String lastName) {
        String sql = "INSERT INTO client(first_name, last_name) values(:first_name, :last_name)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("first_name", firstName);
        paramMap.put("last_name", lastName);
        jdbcTemplate.update(sql, paramMap);

    }

    public void depositHistory(BigInteger accountToId, BigDecimal amount) {
        String sql = "INSERT INTO credit_history(amount, account_to_id) values(:balance, :account_to_id)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_to_id", accountToId);
        paramMap.put("balance", amount);
        jdbcTemplate.update(sql, paramMap);
    }


    public void withdrawHistory(BigInteger accountFromId, BigDecimal amount) {
        String sql = "INSERT INTO credit_history(amount, account_from_id) values(:balance, :account_from_id)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_from_id", accountFromId);
        paramMap.put("balance", amount);
        jdbcTemplate.update(sql, paramMap);
    }

    public void transfer(BigInteger accountFromId, BigInteger accountToId, BigDecimal amount) {
        String sql = "INSERT INTO credit_history(amount, account_from_id, account_to_id) values(:balance, :account_from_id, :account_to_id)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_from_id", accountFromId);
        paramMap.put("account_to_id", accountToId);
        paramMap.put("balance", amount);
        jdbcTemplate.update(sql, paramMap);
    }

    public BigInteger getAccountIdByAccountNumber(String accountNr) {
        String sql = "SELECT id FROM account WHERE account_nr = :accountNumber";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigInteger.class);
    }

    public List<CreditHistory> accountTransferHistory(BigInteger accountFromId) {
        String sql = "SELECT * FROM credit_history WHERE account_from_id = :accountFromId"; //select * - võtame kõik väärtused antud List'ist
        Map<String, BigInteger> paramMap = new HashMap<>();
        paramMap.put("accountFromId", accountFromId);
        return jdbcTemplate.query(sql, paramMap, new ObjectRowMapper3());
    }






  /*  public void transfer(BigDecimal accountFromId, BigDecimal accountToId, BigDecimal amount) {
        String sql = "INSERT INTO credit_history(amount, account_from_id) values(:balance, :account_from_id)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_from_id", accountFromId);
        paramMap.put("account_to_id", accountToId);
        paramMap.put("balance", amount);
        jdbcTemplate.update(sql, paramMap);
    }

   */
}



