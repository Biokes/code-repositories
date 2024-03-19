package dtos;

public class DiaryLoginRequest{
    public DiaryLoginRequest(){}
    private String password;

    public String getUserName(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setUsername(String userName){
        this.username= userName;
    }
    private String username;
}
