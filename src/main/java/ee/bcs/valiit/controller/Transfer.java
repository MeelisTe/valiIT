package ee.bcs.valiit.controller;

import java.math.BigDecimal;

public class Transfer {
    private String receiver;
    private BigDecimal amount;
    private BigDecimal accountFromId;
    private BigDecimal accountToId;
    private String accountNr;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
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
