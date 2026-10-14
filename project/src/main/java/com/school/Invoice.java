
package com.school;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private String invoiceId;
    private Student student;
    private String term;
    private InvoiceStatus status;
    private List<FeeHead> feeHeads;

    public Invoice(String invoiceId, Student student, String term) {

        if (invoiceId == null || invoiceId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Invoice ID cannot be empty"
            );
        }

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null"
            );
        }

        if (term == null || term.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Term cannot be empty"
            );
        }

        this.invoiceId = invoiceId.trim();
        this.student = student;
        this.term = term.trim();
        this.status = InvoiceStatus.UNPAID;
        this.feeHeads = new ArrayList<>();
    }

    public void addFeeHead(FeeHead feeHead) {

        if (feeHead == null) {
            throw new IllegalArgumentException(
                    "Fee head cannot be null"
            );
        }

        feeHeads.add(feeHead);
    }

    public BigDecimal calculateTotal() {

        BigDecimal total = BigDecimal.ZERO;

        for (FeeHead feeHead : feeHeads) {
            total = total.add(feeHead.getAmount());
        }

        return total;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public Student getStudent() {
        return student;
    }

    public String getTerm() {
        return term;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public List<FeeHead> getFeeHeads() {
        return new ArrayList<>(feeHeads);
    }
}
