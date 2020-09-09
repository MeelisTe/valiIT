package ee.bcs.valiit.controller;

import java.math.BigDecimal;

public class Transfer {
    private BigDecimal amount;
    private BigDecimal accountFromId;
    private BigDecimal accountToId;
    private String accountNr;
    private String accountNr1;
    private String accountNr2;

    public String getAccountNr1() {
        return accountNr1;
    }

    public void setAccountNr1(String accountNr1) {
        this.accountNr1 = accountNr1;
    }

    public String getAccountNr2() {
        return accountNr2;
    }

    public void setAccountNr2(String accountNr2) {
        this.accountNr2 = accountNr2;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(BigDecimal accountFromId) {
        this.accountFromId = accountFromId;
    }

    public BigDecimal getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(BigDecimal accountToId) {
        this.accountToId = accountToId;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }
}
