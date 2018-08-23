package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    String name;
    int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
     this.name = name;
     this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade( double averageGrade) {
        for (Student student: students) {
            double averageGradeStudent = student.getAverageGrade();
            if (averageGrade == averageGradeStudent) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAverageGrade = Double.MIN_VALUE;
        Student maxAGStudent = null;
        for (Student student: students) {
            double averageGrade = student.getAverageGrade();
            if (averageGrade > maxAverageGrade) {
                maxAverageGrade = averageGrade;
                maxAGStudent = student;
            };
        }
        return maxAGStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        double minAverageGrade = Double.MAX_VALUE;
        Student minAGStudent = null;
        for (Student student: students) {
            double averageGrade = student.getAverageGrade();
            if (averageGrade < minAverageGrade) {
                minAverageGrade = averageGrade;
                minAGStudent = student;
            };
        }
        return minAGStudent;
    }
    public void expel(Student student) {
        students.remove(student);
    }

}