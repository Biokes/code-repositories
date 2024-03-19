package diaryServicesTest;
import data.models.Diary;
import dtos.CreateDiaryRequest;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(1,service.count());
    }
    @Test
    void deleteDiaryByUserName_testDiaryIsDeleted(){
        CreateDiaryRequest request = new CreateDiaryRequest();
        request.setUsername("name");
        request.setPassword("password");
        service.createDiary(request);
        Assertions.assertEquals(1, service.count());
        service.deleteDiary("name");
        Assertions.assertEquals(0, service.count());
    }
}