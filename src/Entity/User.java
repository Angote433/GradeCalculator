package Entity;

public class User {
    private String userName;
    private String password;

    public User(String name,String password){
        this.userName  = name;
        this.password = password;
    }

    public void setUserName(String name){userName = name;}
    public String getUserName(){return userName;}
    public void setPassword(String password){this.password = password;}
    public String getPassword(){return password;}

}
