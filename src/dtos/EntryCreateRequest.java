package dtos;

public class EntryCreateRequest{
    private String body;
    private String title;

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body=body;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author=author;
    }

    private String author;

}
