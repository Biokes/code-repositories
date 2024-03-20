package DiaryRepoTest;


import data.repositories.EntryImplements;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntryRepoTest{
    private EntryImplements entry = new EntryImplements();
    @BeforeEach
    private void initialize(){
        entry = new EntryImplements();
    }
    @Test
    public void saveEntry_testEntryIsSaved(){

    }
}