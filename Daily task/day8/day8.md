# Day 8 – Invoice Total Calculation

## Work Completed
- Added a list of fee heads to the Invoice class.
- Implemented `addFeeHead()` to add fee items.
- Implemented `calculateTotal()` using BigDecimal.
- Added JUnit tests for invoice total calculation and empty invoices.

## Testing
- Ran `mvn clean test`.
- Build successful.

## Outcome
The invoice can calculate the total fee amount accurately from its fee heads.