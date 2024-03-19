package diaryServicesTest;

import dtos.EntryRequest;
import org.junit.jupiter.api.Test;
import services.EntryService;
import services.EntryServiceImpo;

public class EntryServiceImpoTest{
    @Test
    void createEntry_testEntryIsCreated(){
        EntryService entries = new EntryServiceImpo();
        EntryRequest request = new EntryRequest();
        request.setUserName("user name");
        request.setPassword("password");
        entries.createEntry(null);
    }
}
