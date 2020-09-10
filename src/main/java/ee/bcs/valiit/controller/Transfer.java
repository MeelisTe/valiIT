package ee.bcs.valiit.controller;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Transfer {
    private BigDecimal amount;
    private BigInteger accountFromId;
    private BigInteger accountToId;
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

    public BigInteger getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(BigInteger accountFromId) {
        this.accountFromId = accountFromId;
    }

    public BigInteger getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(BigInteger accountToId) {
        this.accountToId = accountToId;
    }


}
