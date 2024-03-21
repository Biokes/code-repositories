package controllers;

import dtos.RegisterDiary;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DiaryControllerTest{
    @Test
    void createDiary_testDiaryIsCreated(){
        DiaryController diaryServices = new DiaryController();
        RegisterDiary request = new RegisterDiary();
        request.setUserName("userName");
        request.setPassword("");
        assertEquals("Invalid details Provided",diaryServices.createDiary(request));
    }
}
