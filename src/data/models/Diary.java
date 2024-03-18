package data.models;

public class Diary{private Diary
    private final String username;
    public Diary(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }

    public int numberOfEntries(){
        return 1;
    }
}
