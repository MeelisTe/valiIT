package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {

    public static final Map<String, Integer> account = new HashMap<>();

    @PostMapping("account")
    public void createAccount(@RequestBody BankAccount account1) {
        account.put(account1.getAccountNr(), account1.getAmount());
        System.out.println(account);
    }

    @GetMapping("account/{accountNr}")
    public Integer getAccount(@PathVariable ("accountNr") BankAccount account1) {
        return account.get(account1);

    }

    // withdraw - PutMapping
    // deposit - PutMapping


    }




  /*  private static final List<BankAccount> bankaccount = new ArrayList();

    @GetMapping("BankAccount")
    public BankAccount account() {
        BankAccount account = new BankAccount();
        account.setAccount("EE1234567890");
        account.setAmount(1000);

        return account;
*/


