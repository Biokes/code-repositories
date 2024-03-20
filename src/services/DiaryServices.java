package services;


import data.models.Diary;
import data.models.Entry;
import dtos.EntryCreateRequest;
import dtos.LogOutRequest;
import dtos.RegisterDiary;

public interface DiaryServices{

    void createDiary(RegisterDiary request);

    long count();
    Diary findDiary(String userName);
    void login();
    void logOut(LogOutRequest logOutRequest);
    void UpdateEntry();
    Entry createEntry(EntryCreateRequest request);
    void deleteEntry();
}
