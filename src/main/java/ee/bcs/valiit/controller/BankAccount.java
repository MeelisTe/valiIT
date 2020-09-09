package ee.bcs.valiit.controller;

import java.math.BigDecimal;
import java.util.List;

public class BankAccount {
    private String accountNr;
    private BigDecimal balance;
    private BigDecimal clientId;


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getClientId() {
        return clientId;
    }

    public void setClientId(BigDecimal clientId) {
        this.clientId = clientId;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public String getAccountNr() {
        return accountNr;
    }


}



