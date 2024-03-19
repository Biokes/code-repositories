package DiaryRepoTest;
import data.models.Entry;
import data.repositories.EntryImplements;
import data.repositories.EntryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.TestCase.assertEquals;
public class EntryImplementsTest{
    private EntryRepository entries= new EntryImplements();
    @BeforeEach
    public void initialize(){
        entries= new EntryImplements();
    }
    @Test
    void createEntry_testEntryIsCreated(){
        entries.save(new Entry());
        Assertions.assertEquals(1, entries.count());
    }
    @Test
    void deleteEntry_testEntryIsDeleted(){
        Entry entry = new Entry();
        entries.save(entry);
        Assertions.assertEquals(1, entries.count());
        entries.delete(entry);
        Assertions.assertEquals(0, entries.count());
    }
    @Test
    void findAllEntry_testEntryISFound(){
        entries.save(new Entry());
        entries.save(new Entry());
        entries.save(new Entry());
        Assertions.assertEquals(3, entries.findAll().size());
    }
    @Test
    void findEntryById_testEntryIsFound(){
        Entry entry = new Entry();
        entry.setId(1);
        entry.setAuthor("Author");
        entries.save(entry);
        entries.save(entry);
        Assertions.assertEquals("Author", entries.findById(1).getAuthor());
    }
    @Test
    void deleteEntryById_testEntryIsDeleted(){
        Entry entry = new Entry();
        entry.setId(3);
        Entry entry1 = new Entry();
        entry1.setId(1);
        entries.save(entry);
        entries.save(entry1);
        entries.delete(1);
        Assertions.assertEquals(1, entries.count());
        Assertions.assertEquals(entry, entries.findById(3));
    }
}
