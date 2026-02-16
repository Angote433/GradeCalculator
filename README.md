# Student Grade Calculator

A Java console application for managing student grades with user authentication and advanced grading features.

## Features

### Authentication
- ✅ User registration with username and password
- ✅ Secure login system
- ✅ **Password encryption using SHA-256 hashing**

### Student Management
- ✅ Add students to the system
- ✅ **Multiple subject support** - Each student can have grades in multiple subjects (Math, English, Science, etc.)
- ✅ View all students with their subjects and grades
- ✅ **Automatic letter grade assignment** (A, B, C, D, F) based on numeric scores

### Grade Analytics
- ✅ Calculate average grade per student
- ✅ Calculate overall class average
- ✅ View grades with letter grade equivalents

### Grading Scale
- A: 90-100
- B: 80-89
- C: 70-79
- D: 60-69
- F: 0-59

## Technologies Used
- **Java 25** (latest version with simplified main method)
- **HashMap** for storing multiple subjects per student
- **ArrayList** for managing students and users
- **SHA-256** for password hashing
- **Exception handling** for input validation

## Project Structure
```
OOP/
├── Entity/
│   ├── User.java          # User model with hashed password
│   └── Student.java       # Student model with subjects
├── Menus/
│   └── Display.java       # UI and menu system
├── service/
│   └── Services.java      # Business logic for student operations
└── util/
    └── PasswordUtil.java  # Password hashing utilities
```

## How to Run
1. Clone the repository
```bash
   git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
```
2. Open in IntelliJ IDEA (or your preferred IDE)
3. Run the `Display.java` file
4. Follow the menu prompts

## Usage Example
1. Create an account with username and password
2. Login with your credentials
3. Add students to the system
4. Add subjects and grades for each student
5. View all students with letter grades
6. Calculate class averages
7. Logout when done

## Security Features
- Passwords are **never stored in plain text**
- SHA-256 hashing algorithm used for password security
- Password verification without exposing original password

## Future Features (Coming Soon)
- [ ] JavaFX Graphical User Interface
- [ ] File persistence (save/load data)
- [ ] Search for specific students
- [ ] Edit and delete students
- [ ] Find top/bottom performers
- [ ] Grade statistics and charts
- [ ] Export reports to PDF

## What I Learned
- Object-Oriented Programming (OOP) concepts
- Working with Collections (ArrayList, HashMap)
- Password security and hashing
- Exception handling
- Multi-class application architecture
- Version control with Git

## Author
[Arnold Angote]

## Version History
- **v2.0** (Current) - Multiple subjects, letter grades, password encryption
- **v1.0** - Basic grade calculator with login system

## License
This project is for educational purposes.