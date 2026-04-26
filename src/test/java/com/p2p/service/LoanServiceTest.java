package com.p2p.service;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceTest {

    private LoanService loanService;

    // Berjalan sebelum setiap @Test dieksekusi untuk memastikan state fresh
    @BeforeEach
    void setUp() {
        loanService = new LoanService();
    }

    // ==========================================
    // TC-01: Borrower tidak terverifikasi (KYC)
    // ==========================================
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        Borrower borrower = new Borrower(false, 700);
        BigDecimal amount = BigDecimal.valueOf(1000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
        
        assertEquals("Borrower not verified", exception.getMessage());
    }

    // ==========================================
    // TC-02: Amount <= 0 harus ditolak
    // ==========================================
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        Borrower borrower = new Borrower(true, 700);
        
        // Skenario 1: Amount Nol
        Exception exceptionZero = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.ZERO);
        });
        assertEquals("Amount must be greater than 0", exceptionZero.getMessage());

        // Skenario 2: Amount Negatif
        Exception exceptionNegative = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.valueOf(-500));
        });
        assertEquals("Amount must be greater than 0", exceptionNegative.getMessage());
    }

    // ==========================================
    // TC-03: Credit Score Tinggi -> APPROVED
    // ==========================================
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {
        Borrower borrower = new Borrower(true, 600); // 600 adalah batas threshold
        BigDecimal amount = BigDecimal.valueOf(1000);

        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.APPROVED, loan.getStatus());
        assertEquals(amount, loan.getAmount());
    }

    // ==========================================
    // TC-04: Credit Score Rendah -> REJECTED
    // ==========================================
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {
        Borrower borrower = new Borrower(true, 599); // Di bawah threshold
        BigDecimal amount = BigDecimal.valueOf(1000);

        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}