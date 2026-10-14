
package com.school;

public class InvoiceFactory {

    public Invoice createInvoice(
            String invoiceId,
            Student student,
            String term
    ) {
        return new Invoice(invoiceId, student, term);
    }
}
