package dtos;

public class CreateDiaryRequest{
    public void setUsername(String userName){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    private String password;
    private String username;
}
