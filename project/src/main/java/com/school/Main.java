package com.school;

public class Main {

    public static void main(String[] args) {

        Student student = new Student("S001", "Anu", "10-A");

        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Class: " + student.getClassName());
    }
}