package test.DiaryRepoTest;

import data.models.Diary;
import data.models.Entry;
import data.repositories.DiaryImp;
import data.repositories.EntryImplements;
import data.repositories.EntryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.TestCase.assertEquals;

public class EntryImplementsTest{
    private EntryRepository entry = new EntryImplements();
    @BeforeEach
    public void initialize(){
        entry = new EntryImplements();
    }
@Test
    public void testCreateEntrySaveEntry_EntryIsSaved(){
    Entry entry1 = new Entry();
    entry.save(entry1);
    entry.save(entry1);
    assertEquals(2, entry.count());
}
@Test
    void createMulitipleEntriesThenDeleteEntry_testEntryIsDeleted(){
    Entry entry1 = new Entry();
    entry.save(entry1);
    entry.save(entry1);
    assertEquals(2, entry.count());
    entry.delete(entry1);
    assertEquals(1, entry.count());
}
@Test
    void test_AddEntryDeleteEntry_EntryIsAddedAndDeleted(){
        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        entry.save(entry1);
        entry.save(entry2);
        entry.save(entry1);
        entry.save(entry2);
        entry.delete(entry1);
        entry.delete(entry1);
        entry.delete(entry2);
        assertEquals(1,entry.count());
        entry.delete(entry2);
        assertEquals(0, entry.count());
    }
    @Test
    void test_saveDiary_diaryIsSaved(){
        Entry diary = new Entry();
        for(int number = 0; number< 5; number++)
            entry.save(diary);
        assertEquals(5,entry.count());
    }
}
