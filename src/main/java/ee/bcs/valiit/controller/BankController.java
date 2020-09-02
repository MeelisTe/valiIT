package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {

    public static final Map<String, BigDecimal> account = new HashMap<>();
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("sqltest")
    public String testSql() {
        String sql = "SELECT * FROM account WHERE id = :0";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("0", 1);
        String vastus = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return vastus;
    }


    @PostMapping("account") // PostMapping - sisestame andmed, antud juhul accountNr ja getAmount
    public void createAccount(@RequestBody BankAccount account1) {
        account.put(account1.getAccountNr(), account1.getAmount());
        System.out.println(account);

    }

    @GetMapping("account/{accountNr}") // - GetMapping - küsime andmed
    public BigDecimal getAccount(@PathVariable("accountNr") String accountNr) {
        return account.get(accountNr);

    }

    @PutMapping("account/deposit/{accountNr}") // - PutMapping - saame muuta infot
    public BigDecimal depositMoney(@PathVariable("accountNr") String accountNr, @RequestBody BigDecimal amount) {
        BigDecimal newAmount = account.get(accountNr).add(amount);
        account.put(accountNr, newAmount);
        return account.get(accountNr);

    }

    @PutMapping("account/withdraw/{accountNr}") // - PutMapping - saame muuta(üle kirjutada) infot
    public BigDecimal withdrawMoney(@PathVariable("accountNr") String accountNr, @RequestBody BigDecimal amount) {
        BigDecimal accountbalance = account.get(accountNr); // nt. BigDecimal accountbalance = new BigDecimal(val: "10");
        if (accountbalance.compareTo(amount) > 0) {         // võrdleme kas kontol on piisavalt raha
            System.out.println("Väljastan: " + amount);
            account.put(accountNr, account.get(accountNr).subtract(amount));
            return account.get(accountNr);
        } else {
            System.out.println("Kontol pole piisavalt raha, maksimaalne väljavõtu summa: " + accountbalance);
            return account.get(accountNr);
        }
        //  account.put(accountNr, account.get(accountNr).subtract(amount));


    }

    @PutMapping("account/transfer/{accountNr1}/{accountNr2}") // - PutMapping - saame muuta(üle kirjutada) infot
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


    // withdraw - PutMapping
    // deposit - PutMapping


}


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


