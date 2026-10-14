package com.school;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

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

    @Test
    void shouldCalculateInvoiceTotal() {
        Student student = new Student("S101", "Arun", "10-A");
        Invoice invoice = new Invoice("INV101", student, "Term 1");

        invoice.addFeeHead(
                new FeeHead("Tuition", new BigDecimal("20000"))
        );
        invoice.addFeeHead(
                new FeeHead("Transport", new BigDecimal("5000"))
        );
        invoice.addFeeHead(
                new FeeHead("Exam", new BigDecimal("1000"))
        );

        assertEquals(
                0,
                new BigDecimal("26000").compareTo(invoice.calculateTotal())
        );
    }

    @Test
    void shouldReturnZeroForInvoiceWithNoFeeHeads() {
        Student student = new Student("S101", "Arun", "10-A");
        Invoice invoice = new Invoice("INV102", student, "Term 1");

        assertEquals(
                0,
                BigDecimal.ZERO.compareTo(invoice.calculateTotal())
        );
    }
    
    @Test
    void shouldCreateInvoiceUsingFactory() {
        InvoiceFactory factory = new InvoiceFactory();
        Student student = new Student("S101", "Arun", "10-A");

        Invoice invoice = factory.createInvoice(
                "INV103", student, "Term 1"
        );

        assertEquals("INV103", invoice.getInvoiceId());
        assertEquals(student, invoice.getStudent());
        assertEquals("Term 1", invoice.getTerm());
        assertEquals(InvoiceStatus.UNPAID, invoice.getStatus());
    }
    
    @Test
    void shouldDisplayInvoiceDetails() {
        Student student = new Student("S101", "Arun", "10-A");
        Invoice invoice = new Invoice("INV104", student, "Term 1");

        invoice.addFeeHead(
                new FeeHead("Tuition", new BigDecimal("20000"))
        );
        invoice.addFeeHead(
                new FeeHead("Transport", new BigDecimal("5000"))
        );

        java.io.ByteArrayOutputStream output =
                new java.io.ByteArrayOutputStream();

        System.setOut(new java.io.PrintStream(output));

        try {
            invoice.displayInvoice();
        } finally {
            System.setOut(new java.io.PrintStream(
                    new java.io.FileOutputStream(java.io.FileDescriptor.out)
            ));
        }

        String result = output.toString();

        assertTrue(result.contains("INV104"));
        assertTrue(result.contains("Arun"));
        assertTrue(result.contains("Tuition: Rs. 20000"));
        assertTrue(result.contains("Total: Rs. 25000"));
        assertTrue(result.contains("Status: UNPAID"));
    }

}