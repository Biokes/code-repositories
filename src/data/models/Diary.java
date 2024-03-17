package data.models;

public class Diary{
    private final String username;
    public Diary(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }

    public String toString(){
        return String.format("""
                %s
                """, getUsername());
    }
}
