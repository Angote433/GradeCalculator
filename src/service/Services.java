package service;

import Entity.Student;
import Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Services {
    static List<Student>students = new ArrayList<>();;

    public static void addStudent(String name){
        Student student = new Student(name);
        students.add(student);
        System.out.println("Students added successfully.");
    }

    public static void addSubjectsToStudent(String studentName ,String subject,double grade){
        for(Student student : students){
            if(student.getName().equalsIgnoreCase(studentName)){
                student.addSubjects(subject , grade);
                System.out.println("SUbject added successfully");
                return;
            }
            System.out.println("Student not found");
        }

    }

    public static void displayAllStudents(){
        if(students.isEmpty()){
            System.out.println("No students to display");
            return;
        }

        for(Student student : students){
            System.out.println("\nName: "+ student.getName());
            Map<String , Double>subjects = student.getSubjects();

            if(subjects.isEmpty()){
                System.out.println("No subjects to display!!");
            }else{
                for(Map.Entry<String,Double>entry:subjects.entrySet()){
                    double grade = entry.getValue();
                    String letterGrade = Student.getLetterGrade(grade);
                    System.out.println("  " + entry.getKey() + ": " + grade + " (" + letterGrade + ")");
                }
                double averageGrade = student.getAveragePerStudent();
                System.out.println("  Average: " + String.format("%.2f", averageGrade) + " (" + Student.getLetterGrade(averageGrade) + ")");            }
        }

    }

    public  static  double calculateAverage(){
        if(students.isEmpty()){
            System.out.println("No students to display");
            return 0.0;
        }
        double totalMarks = 0;
        int count = 0;
        for(Student student : students){
            if(!student.getSubjects().isEmpty())
            totalMarks += student.getAveragePerStudent();
            count ++;
        }

        return count > 0 ?  totalMarks / count : 0.0;

    }




}
