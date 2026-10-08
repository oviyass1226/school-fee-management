# Day 3 – Invoice, Concession and Payment Implementation

## Objective

Implement invoice generation, concession calculation, payment processing, receipt generation, and invoice status management.

## Tasks

### 1. Invoice Management
- Create the `Invoice` class.
- Generate term-wise invoices for students.
- Calculate invoice totals using `BigDecimal`.
- Create `InvoiceRepository`.
- Use `Map<String, Invoice>` for invoice lookup.
- Create `InvoiceFactory` for invoice creation.

### 2. Concession Management
- Create the `ConcessionStrategy` interface.
- Implement `PercentageConcession`.
- Implement `FixedConcession`.
- Calculate concession amount.
- Calculate the revised payable amount.

### 3. Payment Management
- Create the `PaymentProcessor` interface.
- Implement `MockPaymentProcessor`.
- Create `PaymentService`.
- Validate payment amount.
- Reject invalid payments.
- Prevent payment for already-paid invoices.

### 4. Receipt Generation
- Create the `Receipt` class.
- Generate a receipt after successful payment.
- Use Builder Pattern for creating receipts.

### 5. Invoice Status

Implement the following statuses:

- `UNPAID`
- `PARTIALLY_PAID`
- `PAID`

### 6. Defaulter Management
- Use `Queue<Invoice>` for unpaid/defaulter invoices.
- Identify invoices that are still unpaid.

### 7. Exception Handling

Create:

- `InvalidPaymentException` – Checked Exception
- `InvoiceNotFoundException` – Unchecked Exception

### 8. Testing

Create JUnit tests for:

- Fee structure creation
- Invoice generation
- Invoice total calculation
- Percentage concession
- Fixed concession
- Successful payment
- Invalid payment
- Invoice not found

### 9. Final Verification

Run:

```bash
mvn clean
mvn test
mvn package