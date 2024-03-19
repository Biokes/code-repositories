package data.models;


import dtos.DiaryLoginRequest;
import exceptions.InvalidDetailsException;

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
    private void verifyPassword(DiaryLoginRequest request){
        if(password.equals(request.getPassword())){
            isLocked=true;
        }else throw new InvalidDetailsException();
    }
//    public void login(DiaryLoginRequest request){
//        validateRequest(request);
//        verifyPassword(request);
//    }
//    private void validateRequest(DiaryLoginRequest loginRequest){
//        if(loginRequest.getUserName().trim().isEmpty())
//            throw new InvalidDetailsException();
//        if(loginRequest.getPassword().trim().isEmpty())
//            throw new InvalidDetailsException();
//    }
    public boolean isLoggedIn(){
        return isLocked;
    }
    private String username;
    private String password;
    private boolean isLocked;

    public void setLock(boolean condition){
        isLocked = condition;
    }
}
