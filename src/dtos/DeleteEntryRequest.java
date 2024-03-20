package dtos;

public class DeleteEntryRequest{
    public DeleteEntryRequest(String userName, String password, String title){
        this.username = userName;
        this.password = password;
        this.title = title;
    }
    private String username;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    private String title;
    private String password;
}
