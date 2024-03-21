package dtos;

public class DeleteEntryRequest{
    public DeleteEntryRequest(String author, String password, String title){
        this.author = author;
        this.password = password;
        this.title = title;
    }
    private String author;

    public String getAuthor(){
        return author;
    }

    public void setUsername(String username){
        this.author=username;
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
