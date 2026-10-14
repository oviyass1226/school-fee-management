# Day 9 – Invoice Factory and Repository

## Work Completed
- Created `InvoiceFactory` to centralize invoice creation.
- Created `InvoiceRepository` using `Map<String, Invoice>`.
- Implemented invoice storage and retrieval by invoice ID.
- Added validation for null invoices, duplicate IDs, and empty IDs.
- Added JUnit tests for invoice creation and repository operations.

## Testing
- Ran `mvn clean test`.
- Build successful.

## Outcome
Invoices can be created through a factory and stored and retrieved using their invoice IDs.