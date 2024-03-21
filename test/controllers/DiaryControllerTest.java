package controllers;
import dtos.LogOutRequest;
import dtos.LoginRequest;
import dtos.RegisterDiary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class DiaryControllerTest{
    @Test
    void createDiaryInvalidDetails_testDiaryIsNotCreated(){
        DiaryController diaryServices = new DiaryController();
        RegisterDiary request = new RegisterDiary();
        request.setUserName("userName");
        request.setPassword("");
        Assertions.assertEquals("Invalid details Provided",diaryServices.createDiary(request));
    }
    @Test
    void createDiary_testDiaryIsCreated(){
        DiaryController diaryServices = new DiaryController();
        RegisterDiary request = new RegisterDiary();
        request.setUserName("userName");
        request.setPassword("password");
        Assertions.assertEquals("Diary created Successfully.",diaryServices.createDiary(request));
        Assertions.assertEquals(1, diaryServices.count());
    }
    @Test
    void deleteDiaryNotCreated_testDiaryIsNotDeleted(){
        DiaryController diaryServices = new DiaryController();
        LoginRequest request = new LoginRequest();
        request.setPassword("password");
        request.setUserName("password");
        Assertions.assertEquals("Invalid details Provided",diaryServices.deleteDiary(request));
    }
    @Test
    void testDiaryCannotBeDeletedIfLocked(){
        DiaryController diaryServices = new DiaryController();
        RegisterDiary request = new RegisterDiary();
        request.setUserName("userName");
        request.setPassword("password");
        Assertions.assertEquals("Diary created Successfully.",diaryServices.createDiary(request));
        Assertions.assertEquals(1, diaryServices.count());
        LogOutRequest logOutRequest = new LogOutRequest("userName");
        diaryServices.logOut(logOutRequest);
        Assertions.assertTrue(diaryServices.findDiary(logOutRequest.getUserName()).isLocked());
    }
    @Test
    void testDiaryCanBeLoggedInAndUnlogged(){
        DiaryController diaryServices = new DiaryController();
        RegisterDiary request = new RegisterDiary();
        request.setUserName("userName");
        request.setPassword("password");
        Assertions.assertEquals("Diary created Successfully.",diaryServices.createDiary(request));
        Assertions.assertEquals(1, diaryServices.count());
        LogOutRequest logOutRequest = new LogOutRequest("userName");
        Assertions.assertFalse(diaryServices.findDiary(logOutRequest.getUserName()).isLocked());
        diaryServices.logOut(logOutRequest);
        Assertions.assertTrue(diaryServices.findDiary(logOutRequest.getUserName()).isLocked());
        LoginRequest request2 = new LoginRequest();
        request2.setUserName(logOutRequest.getUserName( ));
        request2.setPassword(request.getPassword( ));
        diaryServices.logIn(request2);
        Assertions.assertFalse(diaryServices.findDiary(logOutRequest.getUserName()).isLocked());
    }
}
