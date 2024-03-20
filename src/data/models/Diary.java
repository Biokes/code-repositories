package data.models;


public class Diary{
    public void logOut(boolean condition){
        isLocked = condition;
    }
    public String getPassword(){
        return password;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username =username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public boolean isLocked(){
        return isLocked;
    }
    private String username;
    private String password;
    private boolean isLocked;


}
