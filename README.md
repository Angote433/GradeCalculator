# Grade Calculator with User Authentication

A Java console application that allows users to create accounts, log in, and manage student grades but with jsut simple average calculation features.

## 📋 Project Overview

This is a student management system built in Java that demonstrates core Object-Oriented Programming (OOP) concepts. The application provides user authentication and grade management functionality through a command-line interface.

## ✨ Features

### User Authentication
- **Create Account**: New users can register with a username and password
- **Login System**: Secure login with credential validation
- **Password Confirmation**: Ensures users enter their password correctly during registration
- **Duplicate Username Prevention**: Checks if username already exists before creating account

### Grade Management
- **Add Students**: Add students with their names and grades to the system
- **View All Students**: Display a list of all students and their grades
- **Calculate Average**: Automatically calculate the average grade across all students
- **User-Specific Sessions**: Each logged-in user has their own session

### Error Handling
- Input validation for menu choices
- Exception handling for invalid input types
- User-friendly error messages

## 🏗️ Project Structure

```
OOP/
├── Entity/
│   ├── User.java          # User model (username, password)
│   └── Student.java       # Student model (name, grade)
├── Menus/
│   └── Display.java       # UI logic and menu displays
└── service/
    └── Services.java      # Business logic for student operations
```

## 🛠️ Technologies Used

- **Java 25**: Latest JDK with simplified main method syntax
- **Collections Framework**: ArrayList for data storage
- **Exception Handling**: InputMismatchException handling
- **OOP Principles**: Encapsulation, separation of concerns

## 🚀 How to Run

1. Clone the repository:
```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
```

2. Navigate to the project directory:
```bash
cd YOUR_REPO_NAME
```

3. Compile and run:
```bash
javac Menus/Display.java
java Menus.Display
```

## 💡 Usage

1. **Main Menu**: Choose to create an account, login, or exit
2. **Create Account**: Enter a unique username and password
3. **Login**: Use your credentials to access the grade calculator
4. **Grade Calculator Menu**:
   - Add students with their grades
   - View all students and their grades
   - Calculate the average grade
   - Logout when finished

## 📚 Learning Objectives

This project was built to practice and demonstrate:
- Object-Oriented Programming concepts (classes, objects, methods)
- Working with multiple classes and packages
- ArrayList manipulation and iteration
- User input handling with Scanner
- Exception handling
- Static vs instance members
- Basic authentication logic
- Separation of concerns (UI vs Business Logic)

## 🔮 Future Enhancements

- [ ] Add JavaFX GUI interface
- [ ] Find highest and lowest grades
- [ ] Delete and update student records
- [ ] Save data to file (persistence)
- [ ] Grade validation (0-100 range)
- [ ] Search functionality for specific students
- [ ] Password encryption
- [ ] Multiple subject support per student

## 📝 Version History

### v1.0.0 (Current)
- Initial release
- User authentication system
- Basic grade calculator functionality
- Console-based interface

## 👨‍💻 Author

Built as a learning project while studying Java and Object-Oriented Programming.

## 📄 Licenses

This project is open source and available for educational purposes.
