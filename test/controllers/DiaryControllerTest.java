package controllers;

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
    void deleteDiary_testDiaryIsDeleted(){}
}