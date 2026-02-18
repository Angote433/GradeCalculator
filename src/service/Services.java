package service;

import Entity.Student;
import Entity.User;
import util.FileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Services {
    static List<Student>students = new ArrayList<>();

    public static void loadStudentsFromFile(){
        students = FileManager.loadStudents();
    }
    public static void saveStudentsToFile() {
        FileManager.saveStudents(students);
    }

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

    public static void searchStudentByName(String studentName){
        if(students.isEmpty()){
            System.out.println("No student available! ");
        }
        for(Student student : students){
            if(student.getName().equals(studentName)){
                System.out.println("=== Student information ====");
                System.out.println("Student name: "+ student.getName());

                Map<String , Double>subjects = student.getSubjects();
                if(subjects.isEmpty()){
                    System.out.println("No subjects to display ");
                }else {
                    for (Map.Entry<String, Double> entry : subjects.entrySet()) {
                        double grade = entry.getValue();
                        String letterGrade = student.getLetterGrade(grade);
                        System.out.println("  " + entry.getKey() + ": " + grade + " (" + letterGrade + ")");

                    }
                }



            }else{
                System.out.println("Student not found!! ");
            }
        }

    }
   public static void findTopPerformer(){
      if(students.isEmpty()){
          System.out.println("No students to analyse");
          return;
       }
      Student topStudent = null;
      double highestAverage = -1;

      for(Student student : students){
          double average = student.getAveragePerStudent();
          if(average > highestAverage){
              highestAverage = average;
              topStudent = student;
          }
      }
      if(topStudent != null){
          System.out.println("===Top performer===");
          System.out.println("Student: "+ topStudent.getName());
          System.out.println("Average: " + String.format("%.2f", highestAverage) + " (" + Student.getLetterGrade(highestAverage) + ")");
      }else{
          System.out.println("No students with grades yet. ");
      }
   }

   public static void findLowestPerformer(){
        if(students.isEmpty()){
            System.out.println("No students to analyse");
        }
        Student bottomStudent = null;
        double lowestAverage = 101;

        for(Student student : students){
            double average = student.getAveragePerStudent();
            if(average < lowestAverage){
                lowestAverage = average;
                bottomStudent = student;
            }
        }

        if(bottomStudent != null){
            System.out.println("Lowest performer: "+ bottomStudent.getName());
            System.out.println("Average: " + String.format("%.2f", lowestAverage) +
                    " (" + Student.getLetterGrade(lowestAverage) + ")");

        }else{
            System.out.println("No student with grades yet");
        }


   }

   public static void editSubjectGrade(String studentName , String subjectName,double newGrade){
        for(Student student : students){
            if(student.getName().equalsIgnoreCase(studentName)){
                if(student.updateGrade(subjectName,newGrade)) {
                    System.out.println("Grade edited successfully");
                }else{
                    System.out.println("Subject not found for this student.");
                }
                return;
            }

        }
       System.out.println("Student not found!!!");
   }

   public static void showGradeStatistics(){
       if (students.isEmpty()) {
           System.out.println("No students to analyze");
           return;
       }

       int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
       int totalStudents = 0;

       for (Student student : students) {
           if (!student.getSubjects().isEmpty()) {
               totalStudents++;
               double avg = student.getAveragePerStudent();
               String grade = Student.getLetterGrade(avg);

               switch (grade) {
                   case "A": countA++; break;
                   case "B": countB++; break;
                   case "C": countC++; break;
                   case "D": countD++; break;
                   case "F": countF++; break;
               }
           }
       }

       if (totalStudents == 0) {
           System.out.println("No students with grades yet");
           return;
       }

       System.out.println("\nGrade Distribution:");
       System.out.println("A: " + countA + " students (" + String.format("%.1f", (countA * 100.0 / totalStudents)) + "%)");
       System.out.println("B: " + countB + " students (" + String.format("%.1f", (countB * 100.0 / totalStudents)) + "%)");
       System.out.println("C: " + countC + " students (" + String.format("%.1f", (countC * 100.0 / totalStudents)) + "%)");
       System.out.println("D: " + countD + " students (" + String.format("%.1f", (countD * 100.0 / totalStudents)) + "%)");
       System.out.println("F: " + countF + " students (" + String.format("%.1f", (countF * 100.0 / totalStudents)) + "%)");
       System.out.println("\nTotal students analyzed: " + totalStudents);
   }


}
