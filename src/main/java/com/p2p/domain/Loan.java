package com.p2p.domain;

import java.math.BigDecimal;

public class Loan {
    public enum Status {
        PENDING, APPROVED, REJECTED
    }

    private Status status;
    private BigDecimal amount;

    public Loan() {
        this.status = Status.PENDING;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Status getStatus() {
        return status;
    }

    // Refactoring: Memberikan makna bisnis pada perubahan state
    public void approve() {
        this.status = Status.APPROVED;
    }

    public void reject() {
        this.status = Status.REJECTED;
    }
}