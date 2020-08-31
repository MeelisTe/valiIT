package ee.bcs.valiit.controller;

public class BankAccount {
    private String accountNr;
    private int amount;

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public int getAmount() {
        return amount;
    }
}


