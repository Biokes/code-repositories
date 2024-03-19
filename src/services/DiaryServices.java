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
    void lockDiary();
    void login(DiaryLoginRequest loginRequest);

    void logOut();
    void delete(Diary diary);
    Diary findDiary(String username);
    boolean isDiaryExisting(String username);
}

