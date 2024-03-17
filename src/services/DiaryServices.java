package services;

import data.models.Diary;

public interface DiaryServices{
    Diary createDiary(String userName, String password);
    void deleteDiary(String userName);
    long getDiariesSize();
}
