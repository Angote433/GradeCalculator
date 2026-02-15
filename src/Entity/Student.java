package Entity;

public class Student {
    String name;
    double grade;

    public Student(String name,double grade){
        this.name = name;
        this.grade = grade;

    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}


    public void setGrade(double grade){this.grade = grade;}
    public double getGrade(){return grade;}

}
