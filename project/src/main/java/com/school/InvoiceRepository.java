
package com.school;

import java.util.HashMap;
import java.util.Map;

public class InvoiceRepository {

    private Map<String, Invoice> invoices = new HashMap<>();

    public void addInvoice(Invoice invoice) {

        if (invoice == null) {
            throw new IllegalArgumentException(
                    "Invoice cannot be null"
            );
        }

        String invoiceId = invoice.getInvoiceId();

        if (invoices.containsKey(invoiceId)) {
            throw new IllegalArgumentException(
                    "Invoice already exists: " + invoiceId
            );
        }

        invoices.put(invoiceId, invoice);
    }

    public Invoice getInvoice(String invoiceId) {

        if (invoiceId == null || invoiceId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Invoice ID cannot be empty"
            );
        }

        return invoices.get(invoiceId.trim());
    }

    public Map<String, Invoice> getAllInvoices() {
        return new HashMap<>(invoices);
    }
}
