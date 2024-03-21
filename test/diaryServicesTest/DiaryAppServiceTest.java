package diaryServicesTest;
import data.models.Diary;
import dtos.LogOutRequest;
import dtos.RegisterDiary;
import exceptions.DiaryNotFoundException;
import exceptions.InvalidDetailsException;
import exceptions.UserAlreadyExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryServiceImpo;
import services.DiaryServices;

import static org.junit.Assert.*;
public class DiaryAppServiceTest{
    private DiaryServices diaryService;
    @BeforeEach
    void initialize(){
        diaryService = new DiaryServiceImpo( );
    }
    @Test
    void createDiary_TestDiaryIsCreated(){
        RegisterDiary request = new RegisterDiary();
        request.setUserName("user name");
        request.setPassword("password");
        diaryService.createDiary(request);
        Assertions.assertEquals(1, diaryService.count());
    }
    @Test
    void testDiaryWithExistingUsernameCannotBeCreated(){
        RegisterDiary request = new RegisterDiary();
        request.setUserName("user name");
        request.setPassword("password");
        diaryService.createDiary(request);
        Assertions.assertEquals(1, diaryService.count());
        assertThrows(UserAlreadyExistException.class,()->diaryService.createDiary(request));
    }
    @Test
    void registerWithInvalidDetails_testExceptionIsThrown(){
        RegisterDiary request = new RegisterDiary();
        request.setUserName("user name");
        request.setPassword("");
        assertThrows(InvalidDetailsException.class,()->diaryService.createDiary(request));
        request.setUserName("");
        request.setPassword("password");
        assertThrows(InvalidDetailsException.class,()->diaryService.createDiary(request));
    }
    @Test
    void logIn_testDiaryIsUnLockAfterCreation(){
        RegisterDiary request = new RegisterDiary();
        request.setUserName("user name");
        request.setPassword("password");
        diaryService.createDiary(request);
        Diary diary = diaryService.findDiary("user NAme");
        Assertions.assertFalse(diary.isLocked());
    }
    @Test
    void testIncorrectDetailsThrowsExceptionForLogin(){
        RegisterDiary request = new RegisterDiary();
        request.setUserName("user name");
        request.setPassword("password");
        diaryService.createDiary(request);
        Assertions.assertEquals(1, diaryService.count());
        Assertions.assertThrows(DiaryNotFoundException.class,()->diaryService.findDiary("user NAm"));
    }
    @Test
    void createdEntry_testEntryIsCreated(){
        RegisterDiary request = new RegisterDiary();
        request.setUserName("user name");
        request.setPassword("password");
        diaryService.createDiary(request);
    }
    @Test
    void testDiaryIsLockedAfterLoginOut(){
        RegisterDiary request = new RegisterDiary();
        request.setUserName("user name");
        request.setPassword("password");
        diaryService.createDiary(request);
        Diary diary = diaryService.findDiary("user NAme");
        Assertions.assertFalse(diary.isLocked());
        LogOutRequest logOutRequest = new LogOutRequest("user name");
        diaryService.logOut(logOutRequest);
        Assertions.assertTrue(diaryService.findDiary("user NAme").isLocked());
    }

}