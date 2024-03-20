package diaryServicesTest;

import data.models.Entry;
import dtos.EntryRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.EntryService;
import services.EntryServiceImpo;
public class EntryServiceImpoTest{
    @Test
    void createEntry_testEntryIsCreated(){
        EntryService entries = new EntryServiceImpo();
        entries.createEntry(new EntryRequest());
        Assertions.assertEquals(1,entries.getNumberOfEnteries());
    }
    @Test
    void deleteEntryByTitle_testEntryIsDeleted(){
        EntryService entries = new EntryServiceImpo();
        EntryRequest request = new EntryRequest();
        request.setUserName("user name");
        request.setPassword("password");
        request.setTitle("title");
        request.setId(1);
        entries.createEntry(request);
        Assertions.assertEquals(1,entries.getNumberOfEnteries());
        entries.deleteEntry(request.getId());
    }
}
