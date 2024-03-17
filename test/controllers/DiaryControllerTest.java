package controllers;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryControllerTest{
    private DiaryController diaryController;
    private DiaryRepository diaryRepository;

    @BeforeEach
    void setUp(){
        diaryRepository = new DiaryImp();
        diaryController = new DiaryController(diaryRepository);
    }

    @Test
    public void createDiary(){
        String userName = "Biokes diary";
        String password = "q12467";
    Diary diary = diaryController.createDiary(userName, password);
        System.out.println(diary);
        assertNotNull(diary);
    }
}