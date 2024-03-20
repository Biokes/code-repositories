package DiaryRepoTest;
import data.models.Entry;
import data.repositories.EntryImplements;
import data.repositories.EntryRepository;
import dtos.EntryRequest;
import exceptions.InvalidDetailsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import services.EntryService;
import services.EntryServiceImpo;

public class EntryImplementsTest{
    private EntryService entries= new EntryServiceImpo();
    @BeforeEach
    public void initialize(){
        entries= new EntryServiceImpo();
    }
    @Test
    void createEntry_testEntryIsCreated(){
        entries.createEntry(new EntryRequest());
        Assertions.assertEquals(1, entries.getNumberOfEnteries());
    }
    @Test
    void deleteEntry_testEntryIsDeleted(){
        EntryRequest entry = new EntryRequest();
        entry.setId(1);
        entries.createEntry(entry);
        Assertions.assertEquals(1, entries.getNumberOfEnteries());
        entries.deleteEntry(1);
        Assertions.assertEquals(0, entries.getNumberOfEnteries());
    }
    @Test
    void findAllEntry_testEntryISFound(){
        entries.createEntry(new EntryRequest());
        entries.createEntry(new EntryRequest());
        entries.createEntry(new EntryRequest());
        Assertions.assertEquals(3, entries.getNumberOfEnteries());
    }
    @Test
    void findEntryById_testEntryIsFound(){
        EntryRequest entry = new EntryRequest();
        entry.setId(1);
        entry.setUserName("Author");
        entries.createEntry(entry);
        entries.createEntry(entry);
        Assertions.assertEquals(1, entries.findEntryById(1).getId());
    }

    @Test
    void deleteEntryByTitleTatDoesNotExist_testExceptionIsThrown(){
        Assertions.assertThrows(InvalidDetailsException.class,()->entries.deleteEntry(1));
    }
}
