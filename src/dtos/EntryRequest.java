package dtos;

public class EntryRequest{
    public void setUserName(String userName){
        this.username = userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    private String password;
    private String username;

}
