package diaryServicesTest;

import org.junit.jupiter.api.BeforeEach;
import services.EntryServicesmpo;

public class EntryServiceTest{
    private EntryServicesmpo servicesImpo;
    @BeforeEach
    void initialize(){
        servicesImpo = new EntryServicesmpo();
    }
}
