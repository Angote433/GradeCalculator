package Entity;

import util.PasswordUtil;

public class User {
    private String userName;
    private String hashedPassword;

    public User(String name,String password){
        this.userName  = name;
        this.hashedPassword = PasswordUtil.hashPassword(password);
    }

    public void setUserName(String name){userName = name;}
    public String getUserName(){return userName;}
    public String getHashedPasswordPassword(){return hashedPassword;}

    public boolean verifyPassWord(String passwordToVerify){
        return PasswordUtil.verifyPassword(passwordToVerify,this.hashedPassword);
    }

}
