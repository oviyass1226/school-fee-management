
package com.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceRepositoryTest {

    @Test
    void shouldAddAndRetrieveInvoice() {
        InvoiceRepository repository = new InvoiceRepository();

        Student student = new Student("S101", "Arun", "10-A");
        Invoice invoice = new Invoice("INV101", student, "Term 1");

        repository.addInvoice(invoice);

        assertEquals(invoice, repository.getInvoice("INV101"));
    }

    @Test
    void shouldRejectDuplicateInvoiceId() {
        InvoiceRepository repository = new InvoiceRepository();

        Student student = new Student("S101", "Arun", "10-A");

        repository.addInvoice(
                new Invoice("INV101", student, "Term 1")
        );

        assertThrows(IllegalArgumentException.class, () -> {
            repository.addInvoice(
                    new Invoice("INV101", student, "Term 2")
            );
        });
    }

    @Test
    void shouldRejectNullInvoice() {
        InvoiceRepository repository = new InvoiceRepository();

        assertThrows(IllegalArgumentException.class, () -> {
            repository.addInvoice(null);
        });
    }

    @Test
    void shouldReturnNullForUnknownInvoiceId() {
        InvoiceRepository repository = new InvoiceRepository();

        assertNull(repository.getInvoice("INV999"));
    }

    @Test
    void shouldRejectEmptyInvoiceId() {
        InvoiceRepository repository = new InvoiceRepository();

        assertThrows(IllegalArgumentException.class, () -> {
            repository.getInvoice(" ");
        });
    }
    
    @Test
    void shouldFindExistingInvoice() {
        InvoiceRepository repository = new InvoiceRepository();
        Student student = new Student("S101", "Arun", "10-A");
        Invoice invoice = new Invoice("INV101", student, "Term 1");

        repository.addInvoice(invoice);

        assertEquals(invoice, repository.findInvoice("INV101"));
    }

    @Test
    void shouldThrowExceptionWhenInvoiceNotFound() {
        InvoiceRepository repository = new InvoiceRepository();

        assertThrows(InvoiceNotFoundException.class, () -> {
            repository.findInvoice("INV999");
        });
    }

}
