
package com.school;

public class Invoice {

    private String invoiceId;
    private Student student;
    private String term;
    private InvoiceStatus status;

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
}
