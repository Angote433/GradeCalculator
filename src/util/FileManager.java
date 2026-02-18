package util;

import Entity.Student;
import Entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileManager {
    private static final String USER_FILE = "users.txt";
    private static final  String STUDENT_FILE = "student.txt";

    public static void saveUsers(List<User>users){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))){
            for(User user : users){
                writer.write(user.getUserName() + "," + user.getHashedPasswordPassword());
                writer.newLine();
            }
            System.out.println("User saved sucessfully.");
        }catch (IOException e){
            System.out.println("Error in saving the users: "+ e.getMessage());
        }
    }

    public static List<User> loadUsers(){
        List<User>users = new ArrayList<>();
        File file = new File(USER_FILE);
        if(!file.exists()){
            return users;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))){
            String line;
            while((line = reader.readLine())!= null){
                String [] parts = line.split(",");
                if(parts.length == 2) {
                    User user = new User(parts[0], parts[1], true);
                    users.add(user);
                }
            }
            System.out.println("Users loaded successfully");
        }catch(IOException e){
            System.out.println("Failed to load the users:" + e.getMessage());
        }
        return users;
    }

    public static void saveStudents(List<Student>students){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_FILE))){
            for(Student student : students){
                writer.write(student.getName());

                Map<String ,Double> subjects = student.getSubjects();
                for(Map.Entry<String ,Double>entry : subjects.entrySet()){
                    writer.write("|"+ entry.getKey() + ":" + entry.getValue());
                }
                writer.newLine();
            }
            System.out.println("Students saved successfully");
        }catch(IOException e){
            System.out.println("Error in saving students: "+ e.getMessage());
        }

    }

    public static List<Student>loadStudents(){
        List<Student>students = new ArrayList<>();
        File file = new File(STUDENT_FILE);

        if (!file.exists()) {
            return students;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(STUDENT_FILE))){
            String line;
            while((line = reader.readLine())!= null){
                String[]parts = line.split("\\|");
                if(parts.length > 0){
                    Student student = new Student(parts[0]);

                    //add all subjects
                    for(int i = 1;i < parts.length;i++){
                        String[]subjectgrade = parts[i].split(":");
                        if(subjectgrade.length == 2){
                            String subject = subjectgrade[0];
                            double grade = Double.parseDouble(subjectgrade[1]);
                            student.addSubjects(subject,grade);
                        }
                    }
                    students.add(student);
                }
            }
            System.out.println("Students loaded successfully");
        }catch(IOException e){
            System.out.println("Failed to load students: "+ e.getMessage());
        }
        return students;
    }




}
