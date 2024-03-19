package data.models;


import dtos.DiaryLoginRequest;

public class Diary{
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
    public void login(DiaryLoginRequest request){
        if( password.equals(request.getPassword()))
            isLocked = true;
    }
    public boolean isLoggedIn(){
        return isLocked;
    }
    private String username;
    private String password;
    private boolean isLocked;
}
