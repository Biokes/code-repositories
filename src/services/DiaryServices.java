package services;

import data.models.Diary;
import dtos.CreateDiaryRequest;
import dtos.DiaryLoginRequest;

public interface DiaryServices{
    Diary register(CreateDiaryRequest loginRequest);
    void deleteDiary(String userName);
    long count();
    void addEntry();

    void addEntry(EntryRequest entryRequest);

    void login(DiaryLoginRequest diaryLoginRequest);
    void logOut();
    void delete(Diary diary);
    boolean findDiary(String username);
}

