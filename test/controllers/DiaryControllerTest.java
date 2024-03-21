package controllers;

import dtos.RegisterDiary;
import org.junit.jupiter.api.Test;
import services.DiaryServiceImpo;
import services.DiaryServices;

import static org.junit.Assert.assertEquals;

public class DiaryControllerTest{
    @Test
    void createDiary_testDiaryIsCreated(){
        DiaryContoller diaryServices = new DiaryContoller();
        RegisterDiary request = new RegisterDiary();
        request.setUserName("userName");
        request.setPassword("");
        assertEquals("Invalid details Provided",diaryServices.createDiary(request));
    }
}
