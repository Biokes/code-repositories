package services;

import data.models.Diary;
import dtos.CreateDiaryRequest;
import dtos.DiaryLoginRequest;

public interface DiaryServices{
    Diary createDiary(CreateDiaryRequest loginRequest);
    void deleteDiary(String userName);
    long count();

}
