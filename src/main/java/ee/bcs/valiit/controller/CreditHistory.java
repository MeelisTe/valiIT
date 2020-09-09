package ee.bcs.valiit.controller;

import java.math.BigDecimal;

public class CreditHistory {
    private BigDecimal amount;
    private BigDecimal accountFromId;
    private BigDecimal accountToId;

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
}
