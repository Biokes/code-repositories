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
        assertEquals(0, entyrRepo.findAll().size());
        entyrRepo.save(new Entry());
        entyrRepo.save(new Entry());
        assertEquals(2, entyrRepo.findAll().size());
    }
    @Test
    public void findEntryById_testEntryISGotten(){
        Entry entry = new Entry();
        entry.setId(1);
        entyrRepo.save(entry);
        assertEquals(entry, entyrRepo.findById(1));
    }
   @Test
    void findEntryByTitle_testEntryIsReturned(){
        Entry entry = new Entry();
        entry.setTitle("name");
        entry.setId(5);
        entyrRepo.save(entry);
        assertEquals(entry, entyrRepo.findByTitle("name"));
   }
   @Test
   public void deleteEntryById_testEntryIsDeleted(){
       Entry entry = new Entry();
       entry.setTitle("name");
       entry.setId(5);
       entyrRepo.save(entry);
       entyrRepo.deleteById(5);
       assertEquals(0, entyrRepo.count());
   }
}