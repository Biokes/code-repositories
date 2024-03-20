package diaryServicesTest;
import dtos.RegisterDiary;
import exceptions.UserAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryServiceImpo;
import services.DiaryServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
        assertEquals(1, diaryService.count());
    }
    @Test
    void testDiaryWithExistingUsernameCannotBeCreated(){
        RegisterDiary request = new RegisterDiary();
        request.setUserName("user name");
        request.setPassword("password");
        diaryService.createDiary(request);
        assertEquals(1, diaryService.count());
        assertThrows(UserAlreadyExistException.class,()->diaryService.createDiary(request));
    }
    @Test
    void registerWithInvalidDetails_testExceptionIsThrown(){}
    @Test
    void logIn_testDiaryIsUnLockAfterCreation(){}
    @Test
    void testDiaryIsLockedAfterLogingOut(){}
    @Test
    void testIncorrectDetailsThrowsExceptionForLogin(){}
    @Test
    void createdEntry_testEntryIsCreated(){}
    @Test
    void deleteEnry_testEntryIsDeleted(){}
}