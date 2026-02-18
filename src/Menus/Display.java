package Menus;

import Entity.Student;
import Entity.User;
import service.Services;
import util.FileManager;
import util.Validator;

import java.security.Provider;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Display {
    static List<User> users = new ArrayList<>();
    static Scanner userInput = new Scanner(System.in);


    static void main() {
        users = FileManager.loadUsers();
        Services.loadStudentsFromFile();
        displayMenu();

        FileManager.saveUsers(users);
        Services.saveStudentsToFile();
    }

    public static void displayMenu() {

        boolean status = true;
        while (status) {
            try {
                System.out.println("===== Welcome to the System=======-");
                System.out.println("1.Create Account ");
                System.out.println("2.Login ");
                System.out.println("3.Exit ");

                System.out.print("Enter your choice: ");
                int choice = userInput.nextInt();
                userInput.nextLine();


                switch (choice) {
                    case 1:
                        displayCreate();
                        break;
                    case 2:
                        displayLogin();
                        break;
                    case 3:
                        status = false;
                        System.out.println("Thank you for visiting us.Goodbyee!");
                        break;
                    default:
                        System.out.println("Invalid choice.Enter a valid choice(1,2 or 3");

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!! Enter the right input.");
                userInput.nextLine();


            }
        }
    }


    public static void displayLogin() {
        System.out.print("Enter username: ");
        String username = userInput.nextLine();
        System.out.print("Enter password: ");
        String password = userInput.nextLine();

        //check if the user exists
        boolean found = false;
        for (User user : users) {
            if (user.getUserName().equals(username) && user.verifyPassWord(password)) {
                found = true;
                System.out.println("Welcome " + username);
                displayGradeMenu();
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid username or password ");
        }


    }

    public static void displayCreate() {


        System.out.print("Enter new user name: ");
        String userName = userInput.nextLine();

        if(!Validator.isValidUserName(userName)){
            System.out.println("Invalid username!! Must be between 3 - 20 characters,alphnumeric only.");
            return;
        }

        boolean exists = false;
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("User exists,try another user");
            return;
        }


        System.out.print("Create your password: ");
        String password = userInput.nextLine();

        if (!Validator.isValidPassword(password)) {
            System.out.println("Password too short! Must be at least 6 characters.");
            return;
        }

        System.out.println("Confirm your password: ");
        String confirmPass = userInput.nextLine();

        if (password.equals(confirmPass)) {
            User user = new User(userName, password);
            users.add(user);
            System.out.println("Account succesfully created");
            FileManager.saveUsers(users);
        } else {
            System.out.println("Passwords don't match");
        }
    }

    public static void displayGradeMenu() {

        boolean loggedIn = true;
        while (loggedIn) {
            try {
                System.out.println("\n=== Grade Calculator Menu ===");
                System.out.println("1. Add Student");
                System.out.println("2. Add subject to student");
                System.out.println("3. View All Students");
                System.out.println("4. Calculate Overall Average");
                System.out.println("5. Find top performer");
                System.out.println("6. Find lowest performer");
                System.out.println("7. Search ");
                System.out.println("8. Edit subject");
                System.out.println("9. Delete student");
                System.out.println("10. Show Grade Statistics");
                System.out.println("11. Logout");

                System.out.print("Enter your choice: ");
                int choice = userInput.nextInt();
                userInput.nextLine();
                switch (choice) {
                    case 1:
                        addStudentMenu();
                        break;
                    case 2:
                        addSubjectMenu();
                        break;
                    case 3:
                        Services.displayAllStudents();
                        break;
                    case 4:
                        System.out.println("Mean score: " + Services.calculateAverage());
                        break;
                    case 5:
                        Services.findTopPerformer();
                        break;

                    case  6:
                        Services.findLowestPerformer();
                        break;
                    case 7:
                        searchStudentMenu();
                        break;
                    case 8:
                        editSubjectMenu();
                        break;
                    case 9:
                        System.out.println("To be implemented");
                        break;
                    case 10:
                        Services.showGradeStatistics();
                        break;
                    case 11:
                        loggedIn = false;
                        System.out.println("Logged out successfully!");
                        break;



                    default:
                        System.out.println("Invalid choice!");
                        userInput.nextLine();


                }


            } catch (InputMismatchException e) {
                System.out.println("Invalid input!!Enter the right choice");
                userInput.nextLine();
            }
        }


    }
    private static void addStudentMenu(){
        System.out.print("Enter student name: ");
        String studentName = userInput.nextLine();
        if(!Validator.isValidName(studentName)){
            System.out.println("Name cannot be empty!! ");
            return;
        }
        Services.addStudent(studentName);

    }
    private static void addSubjectMenu(){
        System.out.print("Enter student name: ");
        String studentName = userInput.nextLine();
        if(!Validator.isValidName(studentName)){
            System.out.println("Invalid name!! Name cannot be empty!!");
            return;
        }

        System.out.print("Enter subject name: ");
        String subject = userInput.nextLine();
        if(!Validator.isValidName(subject)){
            System.out.println("Invalid subject name!! Subject name cannot be empty");
        }

        System.out.print("Enter grade (0-100): ");
        double grade = userInput.nextDouble();
        userInput.nextLine();
        if(!Validator.isValidGrade(grade)){
            System.out.println("Invalid grade!!Grade must be between 0 and 100");
        }

        Services.addSubjectsToStudent(studentName, subject, grade);
    }
    private static void editSubjectMenu(){
        System.out.print("Enter student name: ");
        String studentName = userInput.nextLine();
        System.out.print("Enter subject name: ");
        String subject = userInput.nextLine();
        System.out.print("Enter new grade (0-100): ");
        double newGrade = userInput.nextDouble();
        userInput.nextLine();

        Services.editSubjectGrade(studentName, subject, newGrade);
    }
    private static void searchStudentMenu() {
        System.out.print("Enter student name to search: ");
        String name = userInput.nextLine();
        Services.searchStudentByName(name);
    }
}









