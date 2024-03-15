package test.DiaryRepoTest;

import data.models.Entry;
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
}
