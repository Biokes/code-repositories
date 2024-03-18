package data.models;

import java.util.List;

public class Diary{
    public String getUsername(){
        return this.username;
    }
    private String username;
    private String password;
    private boolean isLocked;

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public boolean isLocked(){
        return isLocked;
    }

    public void setLocked(boolean locked){
        isLocked=locked;
    }
}
