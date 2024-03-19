package DiaryRepoTest;
import data.models.Entry;
import data.repositories.EntryImplements;
import data.repositories.EntryRepository;
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
        assertEquals(1, entries.count());
    }
    @Test
    void deleteEntry_testEntryIsDeleted(){
        Entry entry = new Entry();
        entries.save(entry);
        assertEquals (1, entries.count());
        entries.delete(entry);
        assertEquals (0, entries.count());
    }
    @Test
    void findAllEntry_testEntryISFound(){
        entries.save(new Entry());
        entries.save(new Entry());
        entries.save(new Entry());
        assertEquals(3, entries.findAll().size());
    }
    @Test
    void findEntryById_testEntryIsFound(){
        Entry entry = new Entry();
        entry.setId(1);
        entry.setAuthor("Author");
        entries.save(entry);
        entries.save(entry);
        assertEquals("Author",entries.findById(1).getAuthor());
    }
}
