package dtos;

public class CreateDiaryRequest{
    public void setUsername(String userName){
        this.username = userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    private String password;
    private String username;

    public String getUserName(){
        return username;
    }
    public String getPassword(){
        return this.password;
    }
}
