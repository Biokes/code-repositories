package DiaryRepoTest;

import data.models.Entry;
import data.repositories.EntryImplements;
import data.repositories.EntryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class EntryImplementsTest{
    private EntryRepository entries= new EntryImplements();
    @BeforeEach
    public void initialize(){
        entries= new EntryImplements();
    }
@Test
    public void testCreateEntrySaveEntry_EntryIsSaved(){
    Entry entry1 = new Entry(2);
    entries.save(entry1);
    entries.save(entry1);
    assertEquals(2, entries.count());
}
@Test
    void createMulitipleEntriesThenDeleteEntry_testEntryIsDeleted(){
    Entry entry1 = new Entry(1);
    entries.save(entry1);
    entries.save(entry1);
    assertEquals(2, entries.count());
    entries.delete(entry1);
    assertEquals(1, entries.count());
}
@Test
    void test_AddEntryDeleteEntry_EntryIsAddedAndDeleted(){
        Entry entry1 = new Entry(2);
        Entry entry2 = new Entry(1);
        entries.save(entry1);
        entries.save(entry2);
        entries.save(entry1);
        entries.save(entry2);
        entries.delete(entry1);
        entries.delete(entry1);
        entries.delete(entry2);
        assertEquals(1, entries.count());
        entries.delete(entry2);
        assertEquals(0, entries.count());
    }
    @Test
    void test_saveEntry_entryIsSaved(){
        Entry entry1 = new Entry(3);
        for(int number = 0; number< 5; number++)
            entries.save(entry1);
        assertEquals(5, entries.count());
    }
    @Test
    void findEntryById_testEntryIsFound(){
        Entry entry1 = new Entry(12);
        entries.save(entry1);
        assertEquals(1, entries.count());
        assertEquals(entry1, entries.findById(12));

    }
    @Test
    void deleteEntryByID_entryIsDeleted(){
        Entry entry = new Entry(1);
        entries.save(entry);
        Entry entryFound = entries.findById(1);
        assertEquals(entryFound,entry);
    }
    @Test
    void findEntryByIdDeleteEntry_deleteryEntryFound(){
        Entry entry = new Entry(1);
        entries.save(entry);
        Entry entryFound = entries.findById(1);
        assertEquals(entryFound,entry);
        entries.delete(1);
        assertEquals(0, entries.count());
    }
    @Test
    void test_findAll_AllEntryIsGotten(){
        Entry entry = new Entry(1);
        entries.save(entry);
        assertTrue(entries.count()==1);
        assertEquals(1, entries.findAll().size());
    }
}
