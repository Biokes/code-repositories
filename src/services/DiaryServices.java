package services;

import data.models.Diary;
import dtos.CreateDiaryRequest;
import dtos.DiaryLoginRequest;
import dtos.EntryRequest;

public interface DiaryServices{
    Diary register(CreateDiaryRequest loginRequest);
    void deleteDiary(String userName);
    long count();
    void addEntry(EntryRequest entryRequest);
    void logOut();
    void delete(Diary diary);
    boolean findDiary(String username);
}

