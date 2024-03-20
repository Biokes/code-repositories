package diaryServicesTest;

import dtos.RegisterDiary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryServiceImpo;
import services.DiaryServices;

public class DiaryAppServiceTest{
    private DiaryServices diaryService;
    @BeforeEach
    void initialize(){
        diaryService = new DiaryServiceImpo();
    }
    @Test
    void createDiary_TestDiaryIsCreated(){
        RegisterDiary request = new RegisterDiary();
        request.setUserName("user name");
        request.setPassword("password");
    }

}