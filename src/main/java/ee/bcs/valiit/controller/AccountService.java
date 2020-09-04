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

    public void createAccountUUS() {
        accountRepository.createAccountUUS();
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
            accountRepository.transferMoney(accountNr1, accountNr2, amount);
            return "Transfer successful";
        } else {
            return "Transfer failed, not enough balance.";
        }

    }



    public List allAccounts() {
        return accountRepository.allAccounts();
    }
}
