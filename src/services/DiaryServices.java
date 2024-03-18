package services;

import data.models.Diary;
import dtos.DiaryLoginRequest;

public interface DiaryServices{
    Diary createDiary(DiaryLoginRequest loginRequest);
    void deleteDiary(String userName);
    long getDiariesSize();

}
