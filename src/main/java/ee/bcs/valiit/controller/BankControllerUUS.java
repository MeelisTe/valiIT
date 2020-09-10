package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankControllerUUS {

    public static final Map<String, BigDecimal> account = new HashMap<>();

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountService accountService;


    @GetMapping("getAccountUUS/{accountNr}") // SQL
    public String getAccountUUS(@PathVariable("accountNr") String accountNr) {
        return accountService.getAccount(accountNr);
    }

    @PutMapping("account/depositUUS/{accountNr}") // SQL
    public void depositMoneyUUS(@PathVariable("accountNr") String accountNr, @RequestBody BigDecimal amount) {
        accountService.depositMoney(accountNr, amount);
    }


    @PutMapping("account/withdrawUUS/{accountNr}") // SQL
    public String withdrawMoneyUUS(@PathVariable("accountNr") String accountNr, @RequestBody BigDecimal amount) {
        return accountService.withdrawMoney(accountNr, amount);
    }


    @PutMapping("account/transferUUS/{accountNr1}/{accountNr2}") // SQL
    public String transferMoneyUUS(@PathVariable("accountNr1") String accountNr1, @PathVariable("accountNr2") String
            accountNr2, @RequestBody BigDecimal amount) {
        return accountService.transferMoney(accountNr1, accountNr2, amount);
    }










}


