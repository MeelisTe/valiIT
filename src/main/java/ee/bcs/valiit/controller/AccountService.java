package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


// Ühtegi SQL ei tohi olla service klassis

    public void createAccountUUS(BigDecimal clientId, String accountNr, BigDecimal balance) {
        accountRepository.createAccountUUS(clientId, accountNr, balance);
    }


    public String getAccount(String accountNr) {
        return accountRepository.getAccount(accountNr);
    }

    public void depositMoney(String accountNr, BigDecimal amount) {
        accountRepository.depositMoney(accountNr, amount);
    }


    public String withdrawMoney(String accountNr, BigDecimal amount) {
        BigDecimal accountbalance = accountRepository.getAccountBalance(accountNr, amount);
        if (accountbalance.compareTo(amount) > 0) {         // võrdleme kas kontol on piisavalt raha
            accountRepository.withdrawMoney(accountNr, amount);
            return "Transfer successful";
        } else {
            return "Transfer failed, not enough balance.";
        }

    }


    public String transferMoney(String accountNr1, String accountNr2, BigDecimal amount) {
        BigDecimal accountbalance = accountRepository.getAccountBalance(accountNr1, amount);
        if (accountbalance.compareTo(amount) > 0) {         // võrdleme kas kontol on piisavalt raha
            accountRepository.withdrawMoney(accountNr1, amount);
            accountRepository.depositMoney(accountNr2, amount);
            return "Transfer successful";
        } else {
            return "Transfer failed, not enough balance.";
        }

    }


    public List allAccounts() {

        return accountRepository.allAccounts();
    }

    public List<CreateClient> allClients() {
        return accountRepository.allClients();
    }

    public List<CreditHistory> allCreditHistory() {
        return accountRepository.allCreditHistory();
    }


    public void createClient(String firstName, String lastName) {
        accountRepository.createClient(firstName, lastName);

    }


    public void depositHistory(BigDecimal accountToId, BigDecimal amount, String accountNr) {
        accountRepository.depositMoney(accountNr, amount);
        accountRepository.depositHistory(accountToId, amount);
    }


    public void withdrawHistory(BigDecimal accountFromId, BigDecimal amount, String accountNr) {
        accountRepository.withdrawMoney(accountNr, amount);
        accountRepository.withdrawHistory(accountFromId, amount);
    }

    public String transferHistory(BigDecimal accountFromId, BigDecimal accountToId, BigDecimal amount, String accountNr) {
        BigDecimal accountbalance = accountRepository.getAccountBalance(accountNr, amount);
        if (accountbalance.compareTo(amount) > 0) {
            accountRepository.withdrawMoney(accountNr, amount);
            accountRepository.depositMoney(accountNr, amount);
            accountRepository.transferHistory(accountFromId, accountToId, amount);
            return "Transfer successful";
        } else {
            return "Transfer failed, not enough balance.";
        }
    }
}
