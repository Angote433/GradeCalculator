package Entity;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Map<String , Double> subjects;

    public Student(String name){
        this.name = name;
        this.subjects = new HashMap<>();

    }

    public void addSubjects(String subjectName,double grade){
        subjects.put(subjectName,grade);
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public Map<String , Double>getSubjects(){ return subjects;}

    public double getAveragePerStudent(){
        if (subjects.isEmpty()){
            return 0.0;
        }
        double totalMarks = 0;
        for(double grade : subjects.values()){
            totalMarks += grade;

        }
        return totalMarks / subjects.size();
    }
    public static String getLetterGrade(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }




}
