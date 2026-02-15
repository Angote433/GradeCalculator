package service;

import Entity.Student;
import Entity.User;

import java.util.ArrayList;
import java.util.List;

public class Services {
    static List<Student>students = new ArrayList<>();;

    public static void addStudent(String name,double grade){
        Student student = new Student(name , grade);
        students.add(student);
        System.out.println("Students added successfully.");
    }

    public static void displayAllStudents(){
        if(students.isEmpty()){
            System.out.println("No students to display");
            return;
        }

        for(Student student : students){
            System.out.println("Name: "+ student.getName() +" "+ "Grade: "+ student.getGrade());
        }

    }

    public  static  double calculateAverage(){
        if(students.isEmpty()){
            System.out.println("No students to display");
            return 0.0;
        }
        double totalMarks = 0;
        for(Student student : students){
            totalMarks += student.getGrade();
        }

        return totalMarks / students.size();

    }




}
