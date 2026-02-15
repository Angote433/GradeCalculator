package Menus;

import Entity.Student;
import Entity.User;
import service.Services;

import java.security.Provider;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Display {
    static List<User> users = new ArrayList<>();
    static Scanner userInput = new Scanner(System.in);


    static void main() {
        displayMenu();
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
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
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

        System.out.println("Confirm your password: ");
        String confirmPass = userInput.nextLine();

        if (password.equals(confirmPass)) {
            User user = new User(userName, password);
            users.add(user);
            System.out.println("Account succesfully created");
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
                System.out.println("2. View All Students");
                System.out.println("3. Calculate Average");
                System.out.println("4. Logout");

                System.out.print("Enter your choice: ");
                int choice = userInput.nextInt();
                userInput.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter student's name: ");
                        String name = userInput.nextLine();
                        System.out.print("Enter student's grade: ");
                        double grade = userInput.nextDouble();
                        userInput.nextLine();
                        Services.addStudent(name, grade);
                        break;
                    case 2:
                        Services.displayAllStudents();
                        break;
                    case 3:
                        System.out.println("Mean score: " + Services.calculateAverage());
                        break;
                    case 4:
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
}









