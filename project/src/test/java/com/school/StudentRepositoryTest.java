
package com.school;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Test
    void shouldAddStudentSuccessfully() {
        StudentRepository repository = new StudentRepository();

        Student student = new Student("S101", "Arun", "10-A");

        repository.addStudent(student);

        assertEquals(1, repository.getAllStudents().size());
    }

    @Test
    void shouldRejectDuplicateStudentId() {
        StudentRepository repository = new StudentRepository();

        repository.addStudent(
                new Student("S101", "Arun", "10-A")
        );

        assertThrows(IllegalArgumentException.class, () -> {
            repository.addStudent(
                    new Student("S101", "Priya", "10-B")
            );
        });
    }

    @Test
    void shouldRejectEmptyStudentName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("S102", "", "10-A");
        });
    }
}
