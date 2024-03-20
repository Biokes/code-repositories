package dtos;

public class LogOutRequest{
    private String userName;
    public LogOutRequest(String userName){this.userName = userName;}
    public String getUserName(){return userName;}
}
