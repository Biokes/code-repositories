package diaryServicesTest;

import org.junit.jupiter.api.BeforeEach;
import services.EntryServicesImpo;

public class EntryServiceTest{
    private EntryServicesImpo servicesImpo;
    @BeforeEach
    void initialize(){
        servicesImpo = new EntryServicesImpo();
    }
}
