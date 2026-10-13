
package com.school;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null"
            );
        }

        for (Student existingStudent : students) {
            if (existingStudent.getStudentId()
                    .equalsIgnoreCase(student.getStudentId())) {

                throw new IllegalArgumentException(
                        "Student ID already exists: "
                                + student.getStudentId()
                );
            }
        }

        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
