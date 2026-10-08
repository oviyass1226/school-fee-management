# Day 2 – Student and Fee Structure Implementation

## Objective

Implement the student management and class-wise fee structure functionality using Java and in-memory collections.

## Tasks

### 1. Student Management
- Create the `Student` class.
- Add student ID, name, and class name.
- Create `StudentRepository`.
- Use `List<Student>` to store students.
- Implement adding and retrieving students.
- Add validation for duplicate students.

### 2. Fee Head Management
- Create the `FeeHead` class.
- Store fee head name and amount.
- Support:
  - Tuition Fee
  - Transport Fee
  - Exam Fee
  - Library Fee
- Use `BigDecimal` for fee amounts.
- Prevent duplicate fee heads using `Set<FeeHead>`.

### 3. Fee Structure
- Create the `FeeStructure` class.
- Associate fee heads with a particular class.
- Create `FeeStructureRepository`.
- Store fee structures in memory.
- Validate invalid fee amounts and duplicate fee heads.

## Collections Used

- `List<Student>` – store students.
- `Set<FeeHead>` – store unique fee heads.
- `Map<String, FeeStructure>` – store class-wise fee structures.

## OOP Concepts Applied

- Encapsulation
- Constructors
- `this` keyword
- Classes and objects
- Interfaces where required
- Collection-based in-memory storage

## Expected Outcome

By the end of Day 2:

- Students can be created and stored.
- Fee heads can be created.
- Fee structures can be created for different classes.
- Unique fee heads are maintained.
- Class-wise fee structures are stored in memory.