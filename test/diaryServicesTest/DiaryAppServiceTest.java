package diaryServicesTest;

import data.models.Entry;
import dtos.CreateDiaryRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryAppService;

import static junit.framework.TestCase.assertEquals;

public class DiaryAppServiceTest{
    private DiaryAppService service;
    @BeforeEach
    void initialize(){
        service = new DiaryAppService();
    }
    @Test
    void saveEntry_testEntryIsSaved(){
        CreateDiaryRequest request = new CreateDiaryRequest();
        request.setUsername("user name");
        request.setPassword("password");
        service.createDiary(request);
        assertEquals(1,service.count());
    }
}