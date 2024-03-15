package test.DiaryRepoTest;

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
    public void testCreateEntrySaveEntry_EntryIsSaved(){
    Entry entry1 = new Entry();
    entries.save(entry1);
    entries.save(entry1);
    assertEquals(2, entries.count());
}
@Test
    void createMulitipleEntriesThenDeleteEntry_testEntryIsDeleted(){
    Entry entry1 = new Entry();
    entries.save(entry1);
    entries.save(entry1);
    assertEquals(2, entries.count());
    entries.delete(entry1);
    assertEquals(1, entries.count());
}
@Test
    void test_AddEntryDeleteEntry_EntryIsAddedAndDeleted(){
        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
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
        Entry entry1 = new Entry();
        for(int number = 0; number< 5; number++)
            entries.save(entry1);
        assertEquals(5, entries.count());
    }
    @Test
    void findEntryById_testEntryIsFound(){
        Entry entry1 = new Entry();
        entries.save(entry1);
        assertEquals(1, entries.count());

    }
}
