package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankControllerHTML {

    public static final Map<String, BigDecimal> account = new HashMap<>();

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountService accountService;

    @PostMapping("createClient") // SQL
    public void createClient(@RequestBody CreateClient client) {
        accountService.createClient(client.getFirstName(), client.getLastName());
    }

    @PostMapping("createAccountUUS") // SQL
    public void createAccountUUS(@RequestBody BankAccount account) {
        accountService.createAccountUUS(account.getClientId(), account.getAccountNr(), account.getBalance());

    }

    @PostMapping("depositHistory")
    public void depositHistory(@RequestBody Transfer deposit) {
        accountService.depositHistory(deposit.getAccountToId(), deposit.getAmount(), deposit.getAccountNr1());
    }

    @PostMapping("withdrawHistory")
    public void withdrawHistory(@RequestBody Transfer withdraw) {
        accountService.withdrawHistory(withdraw.getAccountFromId(), withdraw.getAmount(), withdraw.getAccountNr1());
    }

    @PostMapping("transfer")
    public void transfer(@RequestBody Transfer transfer) {
        accountService.transfer( transfer.getAmount(), transfer.getAccountNr1(), transfer.getAccountNr2());
    }

    @GetMapping("allAccountsUUS") // SQL
    public List<BankAccount> allAccountsUUS() {

        return accountService.allAccounts();
    }

    @GetMapping("allClientsUUS") // SQL
    public List<CreateClient> allClientsUUS() {

        return accountService.allClients();
    }

    @GetMapping("allCreditHistory") // SQL
    public List<CreditHistory> allCreditHistory() {

        return accountService.allCreditHistory();
    }

    @GetMapping("accountTransferHistory/{accountNr}") // SQL
    public List<CreditHistory> accountTransferHistory(@PathVariable String accountNr) {

        return accountService.accountTransferHistory(accountNr);
    }




}
