
package com.school;

public class Student {

    private String studentId;
    private String name;
    private String className;

    public Student(String studentId, String name, String className) {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }

        if (className == null || className.trim().isEmpty()) {
            throw new IllegalArgumentException("Class name cannot be empty");
        }

        this.studentId = studentId;
        this.name = name;
        this.className = className;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }
}
