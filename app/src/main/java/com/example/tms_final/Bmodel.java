package com.example.tms_final;

public class Bmodel {
    String amount;
    String b_description;

    public Bmodel() {
    }

    public Bmodel(String amount, String b_description) {
        this.amount = amount;
        this.b_description = b_description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getB_description() {
        return b_description;
    }

    public void setB_description(String b_description) {
        this.b_description = b_description;
    }
}
