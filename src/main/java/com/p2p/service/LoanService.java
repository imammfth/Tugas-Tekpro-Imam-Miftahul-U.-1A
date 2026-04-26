package com.p2p.service;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;

public class LoanService {
    
    // Inisialisasi Logger Log4j
    private static final Logger logger = LogManager.getLogger(LoanService.class);
    private static final int CREDIT_SCORE_THRESHOLD = 600;

    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        logger.info("Memulai proses pengajuan pinjaman dengan nominal: {}", amount);

        try {
            validateBorrower(borrower);
            validateAmount(amount);

            Loan loan = new Loan();
            loan.setAmount(amount);

            if (borrower.getCreditScore() >= CREDIT_SCORE_THRESHOLD) {
                loan.approve();
                logger.info("Status Pinjaman: APPROVED. Credit score borrower memenuhi syarat ({}).", borrower.getCreditScore());
            } else {
                loan.reject();
                logger.warn("Status Pinjaman: REJECTED. Credit score borrower di bawah standar ({}).", borrower.getCreditScore());
            }

            return loan;

        } 
        
        catch (IllegalArgumentException e) {
            // Mencatat error jika validasi gagal
            logger.error("Pengajuan pinjaman GAGAL: {}", e.getMessage());
            throw e; // Lempar kembali exception agar Unit Test tetap bisa mendeteksinya
        }
    }

    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }
}