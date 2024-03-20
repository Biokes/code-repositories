package services;


import data.models.Diary;
import data.models.Entry;
import dtos.*;

public interface DiaryServices{

    void createDiary(RegisterDiary request);

    long count();
    Diary findDiary(String userName);
    void login();
    void logOut(LogOutRequest logOutRequest);
    void UpdateEntry(UpdateRequest request);
    Entry createEntry(EntryCreateRequest request);
    void deleteEntry(DeleteEntryRequest request);
}
