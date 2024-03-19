package diaryServicesTest;
import data.models.Diary;
import dtos.CreateDiaryRequest;
import dtos.DiaryLoginRequest;
import exceptions.InvalidDetailsException;
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
        service.register(request);
        Assertions.assertEquals(1,service.count());
    }
    @Test
    void deleteDiaryByUserName_testDiaryIsDeleted(){
        CreateDiaryRequest request = new CreateDiaryRequest();
        request.setUsername("name");
        request.setPassword("password");
        Diary diary = service.register(request);
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
        Diary diary = service.register(request);
        Assertions.assertEquals("name",diary.getUsername() );
        Assertions.assertThrows(UserAlreadyExistException.class,()->service.register(request));
    }
    @Test
    void testLoginDetailsAreValidBeforeCreatingDiary(){
        CreateDiaryRequest request = new CreateDiaryRequest();
        request.setUsername("name");
        request.setPassword("");
        assertThrows(InvalidDetailsException.class,()->service.register(request));
        CreateDiaryRequest newRequest = new CreateDiaryRequest();
        newRequest.setUsername("");
        newRequest.setPassword("name");
        assertThrows(InvalidDetailsException.class,()->service.register(newRequest));
    }
    @Test
    void testThatUserCanlogIn(){
        CreateDiaryRequest request = new CreateDiaryRequest();
        request.setUsername("user name");
        request.setPassword("password");
        Diary diary = service.register(request);
        DiaryLoginRequest loginRequest = new DiaryLoginRequest();
        loginRequest.setUsername("user name");
        loginRequest.setPassword("password");
        service.login(loginRequest);
        Assertions.assertTrue(diary.isLoggedIn());
    }
    @Test
    void incorrectLoginDetails_throwsException(){
        CreateDiaryRequest request = new CreateDiaryRequest();
        request.setUsername("user name");
        request.setPassword("password");
        Diary diary = service.register(request);
        DiaryLoginRequest loginRequest = new DiaryLoginRequest();
        loginRequest.setUsername("user name");
        loginRequest.setPassword("pass word");
        Assertions.assertThrows(InvalidDetailsException.class,()->service.login(loginRequest));
    }

}