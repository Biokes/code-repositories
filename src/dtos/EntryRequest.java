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
    public String getPassword(){ return password;}
    public String getUserName(){
        return username;
    }

    public String getTitle(){
        return title;
    }
    private String title;

    public String getBody(){
        return this.body;
    }
    private String body;

    public void setTitle(String title){
        this.title = title;
    }

    public void setId(int i){
        this.id= i;
    }
    private int id;

    public int getId(){
        return id;
    }
}
