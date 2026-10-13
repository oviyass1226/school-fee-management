
package com.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    @Test
    void shouldCreateInvoiceSuccessfully() {
        Student student = new Student("S101", "Arun", "10-A");

        Invoice invoice = new Invoice("INV101", student, "Term 1");

        assertEquals("INV101", invoice.getInvoiceId());
        assertEquals(student, invoice.getStudent());
        assertEquals("Term 1", invoice.getTerm());
        assertEquals(InvoiceStatus.UNPAID, invoice.getStatus());
    }

    @Test
    void shouldTrimInvoiceIdAndTerm() {
        Student student = new Student("S101", "Arun", "10-A");

        Invoice invoice = new Invoice(" INV101 ", student, " Term 1 ");

        assertEquals("INV101", invoice.getInvoiceId());
        assertEquals("Term 1", invoice.getTerm());
    }

    @Test
    void shouldRejectEmptyInvoiceId() {
        Student student = new Student("S101", "Arun", "10-A");

        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice(" ", student, "Term 1");
        });
    }

    @Test
    void shouldRejectNullStudent() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice("INV101", null, "Term 1");
        });
    }

    @Test
    void shouldRejectEmptyTerm() {
        Student student = new Student("S101", "Arun", "10-A");

        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice("INV101", student, " ");
        });
    }
}
