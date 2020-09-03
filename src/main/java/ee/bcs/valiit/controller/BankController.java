package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankController {

    public static final Map<String, BigDecimal> account = new HashMap<>();
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("sqltest") // SQL
    public String testSql() {
        String sql = "SELECT account_nr FROM account WHERE id = :id";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("id", 1);
        String vastus = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return vastus;
    }

    @PutMapping("sqltest") // SQL
    public void testSql2() {
        String sql = "UPDATE account SET balance = :balance WHERE id = :id";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("balance", 100);
        paramMap.put("id", 1);
        jdbcTemplate.update(sql, paramMap);
    }

    // - tagasta kõigi kontode sisu select *

    /*    sql = "UPDATE account SET balance = :balance WHERE id = :id";
    paramMap.put("balance", 100);
    paramMap.put("id", 2);
    jdbcTemplate.update(sql, paramMap);
*/
/*
    @PostMapping("account") // PostMapping - sisestame andmed, antud juhul accountNr ja getAmount
    public void createAccount(@RequestBody BankAccount account1) {
        account.put(account1.getAccountNr(), account1.getAmount());
        System.out.println(account);

    }
*/
    @PostMapping("account") // SQL
    public void createAccount(@RequestBody BankAccount account1) {
        String sql = "INSERT INTO account(client_id, account_nr, balance) VALUES(100, 552233, 5000)";
        Map<String, Object> paramMap = new HashMap();
        jdbcTemplate.update(sql, paramMap);
    }

    /*    @GetMapping("account/{accountNr}") // - GetMapping - küsime andmed
        public BigDecimal getAccount(@PathVariable("accountNr") String accountNr) {
            return account.get(accountNr);

        }
    */
    @GetMapping("account/{accountNr}") // SQL
    public String getAccount(@PathVariable("accountNr") String accountNr) {
        String sql = "SELECT account_nr FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_nr", accountNr);
        String vastus = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return vastus;
    }

  /*  @PutMapping("account/deposit/{accountNr}") // - PutMapping - saame muuta infot
    public BigDecimal depositMoney(@PathVariable("accountNr") String accountNr, @RequestBody BigDecimal amount) {
        BigDecimal newAmount = account.get(accountNr).add(amount);
        account.put(accountNr, newAmount);
        return account.get(accountNr);

    }
  */

    @PutMapping("account/deposit/{accountNr}") // SQL
    public void depositMoney(@PathVariable("accountNr") String accountNr, @RequestBody BigDecimal amount) {
        String sql = "UPDATE account SET balance = balance + :balance WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("balance", amount);
        paramMap.put("account_nr", accountNr);
        jdbcTemplate.update(sql, paramMap);
    }



 /*  @PutMapping("account/withdraw/{accountNr}") // - PutMapping - saame muuta(üle kirjutada) infot
    public BigDecimal withdrawMoney(@PathVariable("accountNr") String accountNr, @RequestBody BigDecimal amount) {
        BigDecimal accountbalance = account.get(accountNr); // nt. BigDecimal accountbalance = new BigDecimal(val: "10"); accountbalance(BigDecimal) võtame välja konto jäägi account.get käsuga kontolt (accountNr)
        if (accountbalance.compareTo(amount) > 0) {         // võrdleme kas kontol on piisavalt raha
            System.out.println("Väljastan: " + amount);
            account.put(accountNr, account.get(accountNr).subtract(amount));
            return account.get(accountNr);
        } else {
            System.out.println("Kontol pole piisavalt raha, maksimaalne väljavõtu summa: " + accountbalance);
            return account.get(accountNr);
        }
   */     //  account.put(accountNr, account.get(accountNr).subtract(amount));

    /*   @PutMapping("account/withdraw/{accountNr}") // SQL
       public void withdrawMoney(@PathVariable("accountNr") String accountNr, @RequestBody BigDecimal amount) {
           String sql = "UPDATE account SET balance = balance - :balance WHERE account_nr = :account_nr";
           Map<String, Object> paramMap = new HashMap();
           paramMap.put("balance", amount);
           paramMap.put("account_nr", accountNr);
           jdbcTemplate.update(sql, paramMap);
       }
   */
    @PutMapping("account/withdraw/{accountNr}") // SQL
    public String withdrawMoney(@PathVariable("accountNr") String accountNr, @RequestBody BigDecimal amount) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_nr", accountNr);
        BigDecimal accountbalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class); // nt. BigDecimal accountbalance = new BigDecimal(val: "10");

        if (accountbalance.compareTo(amount) > 0) {         // võrdleme kas kontol on piisavalt raha
            String sql2 = "UPDATE account SET balance = balance - :balance WHERE account_nr = :account_nr";
            paramMap.put("balance", amount);
            paramMap.put("account_nr", accountNr);
            jdbcTemplate.update(sql2, paramMap);
            return "Transfer successful";
        } else {
            return "Transfer failed, not enough balance.";
        }
    }


 /*   @PutMapping("account/transfer/{accountNr1}/{accountNr2}") // - PutMapping - saame muuta(üle kirjutada) infot
    public TransferMoneyResponse transferMoney(@PathVariable("accountNr1") String accountNr1, @PathVariable("accountNr2") String accountNr2, @RequestBody BigDecimal amount) {
        TransferMoneyResponse response = new TransferMoneyResponse();
        BigDecimal accountbalance = account.get(accountNr1); // nt. BigDecimal accountbalance = new BigDecimal(val: "10");

        response.setAccount1(accountNr1);
        response.setAccount2(accountNr2);
        response.setBalance1(account.get(accountNr1));
        response.setBalance2(account.get(accountNr2));

        if (accountbalance.compareTo(amount) > 0) {
            account.put(accountNr1, account.get(accountNr1).subtract(amount));
            account.put(accountNr2, account.get(accountNr2).add(amount));
            System.out.println("Transfer successful");
            response.setMessage("Transfer successful");
        } else {
            System.out.println("Not enough balance.");
            response.setMessage("Not enough balance.");
        }
        return response;

    }
*/

    @PutMapping("account/transfer/{accountNr1}/{accountNr2}") // SQL
    public String transferMoney(@PathVariable("accountNr1") String accountNr1, @PathVariable("accountNr2") String
            accountNr2, @RequestBody BigDecimal amount) {
        String sql = "SELECT balance FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account_nr", accountNr1);
        BigDecimal accountbalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        if (accountbalance.compareTo(amount) > 0) {         // võrdleme kas kontol on piisavalt raha
            String sql2 = "UPDATE account SET balance = balance - :balance WHERE account_nr = :account_nr";
            paramMap.put("balance", amount);
            paramMap.put("account_nr", accountNr1);
            jdbcTemplate.update(sql2, paramMap);

            String sql3 = "UPDATE account SET balance = balance + :balance WHERE account_nr = :account_nr";
            paramMap.put("balance", amount);
            paramMap.put("account_nr", accountNr2);
            jdbcTemplate.update(sql3, paramMap);
            return "Transfer successful";
        } else {
            return "Transfer failed, not enough balance.";
        }
    }


    @GetMapping("allaccounts") // SQL
    public List<BankAccount> allaccounts() {
        String sql = "SELECT * FROM account"; //select * - võtame kõik väärtused antud List'ist
        return jdbcTemplate.query(sql, new HashMap(), new ObjectRowMapper()); //võtame sql väärtuse sellest funktsioonist, paneme selle Hashmap kujule, loome uue klassi et esitleda seda objektina)
    }

 /*   @GetMapping("allaccounts1") // SQL
    public List<BankAccount> allaccounts1() {
        String sql = "SELECT * FROM account";
        return jdbcTemplate.query(sql, new HashMap(), new ObjectRowMapper2());
    }
*/


}


// Ülesanne - tagasta kõik kontod andmebaasist

// @GetMapping - @RequestParam - kui tundub segane, siis kasutada lihtsuse mõttes esialgu ainult neid kahte


// withdraw - PutMapping
// deposit - PutMapping





/*      Withdraw tingimus, et kontrollida, kas kontol on piisavalt raha

        BigDecimal accountbalance = account.get(accountNr); // = new BigDecimal(val: "10");
        BigDecimal withdraw = amount;
        if (accountbalance.compareTo(withdraw) > 0) {
            System.out.println("Väljastan: ");
            account.put(accountNr, account.get(accountNr).subtract(amount));
        } else {
            System.out.println("Kontol pole piisavalt raha.");
        }
      */



  /*  private static final List<BankAccount> bankaccount = new ArrayList();

    @GetMapping("BankAccount")
    public BankAccount account() {
        BankAccount account = new BankAccount();
        account.setAccount("EE1234567890");
        account.setAmount(1000);

        return account;
*/


