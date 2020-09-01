package ee.bcs.valiit.controller;

import java.math.BigDecimal;

public class Transfer {
    private String receiver;
    private BigDecimal amount;

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReceiver() {
        return receiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
