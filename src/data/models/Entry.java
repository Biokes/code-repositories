package data.models;

import java.time.LocalDate;

public class Entry{
    private String author;
    private String body;
    private int id;

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author=author;
    }

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

    public LocalDate getDate(){
        return date;
    }

    private String title;
    private LocalDate date = LocalDate.now();

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
