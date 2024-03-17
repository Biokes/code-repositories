package controllers;

import data.models.Diary;
import data.repositories.DiaryRepository;
import services.DiaryAppService;
import services.DiaryServices;

public class DiaryController{
    private DiaryServices diaryServices;
    public DiaryController(DiaryRepository diaryRepository){
        this.diaryServices= new DiaryAppService(diaryRepository);
    }

    public Diary createDiary(String userName, String password){
        return diaryServices.createDiary(userName, password);
    }
}
