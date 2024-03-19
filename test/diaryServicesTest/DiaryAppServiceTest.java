package diaryServicesTest;
import data.models.Diary;
import dtos.CreateDiaryRequest;
import exceptions.UserAlreadyExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryAppService;
import exceptions.DiaryNotFoundException;

import static org.junit.Assert.assertThrows;

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
        Diary diary = service.createDiary(request);
        Assertions.assertEquals("name",diary.getUsername() );
        Assertions.assertEquals(1, service.count());
        service.deleteDiary("name");
        Assertions.assertEquals(0, service.count());
    }
    @Test
    void deleteDiaryByUserNameThatDoesNotExist_throwsException(){
        Assertions.assertThrows(DiaryNotFoundException.class,()->service.deleteDiary("name"));
    }
    @Test
    void createDiaryWithExistingUserName_testExceptionIsThrown(){
        CreateDiaryRequest request = new CreateDiaryRequest();
        request.setUsername("name");
        request.setPassword("password");
        Diary diary = service.createDiary(request);
        Assertions.assertEquals("name",diary.getUsername() );
        Assertions.assertThrows(UserAlreadyExistException.class,()->service.createDiary(request));
    }
}