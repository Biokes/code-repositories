package DiaryRepoTest;


import data.models.Entry;
import data.repositories.EntryImplements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class EntryRepoTest{
    private EntryImplements entyrRepo= new EntryImplements();
    @BeforeEach
    private void initialize(){
        entyrRepo= new EntryImplements();
    }
    @Test
    public void saveEntry_testEntryIsSaved(){
        Entry entry1 = new Entry();
        entyrRepo.save(entry1);
        assertEquals(1, entyrRepo.count());
    }
    @Test
    public void findallEntry_testAllEntryIsGotten(){
        assertEquals(0, entyrRepo.findAll());
        entyrRepo.save(new Entry());
        entyrRepo.save(new Entry());
        assertEquals(2, entyrRepo.findAll());
    }
}