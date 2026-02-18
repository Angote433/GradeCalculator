package util;

public class Validator {
    //grade to be between 0 and 100
    public static boolean isValidGrade(double grade){
        return grade >= 0 && grade <= 100;
    }

    //name not empty
    public static boolean isValidName(String name){
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidUserName(String userName){
        if(userName == null || userName.length() < 3 || userName.length() > 20 ){
            return false;
        }
        return userName.matches("[a-zA-Z0-9]+");
    }

    //minimum 6 characters
    public static boolean isValidPassword(String password){
        return password != null && password.length() >= 6;
    }

}
