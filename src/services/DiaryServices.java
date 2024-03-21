package services;


import data.models.Diary;
import data.models.Entry;
import dtos.*;

import java.util.List;

public interface DiaryServices{

    void createDiary(RegisterDiary request);
    void deleteDiary(LoginRequest diary);
    long count();
    Diary findDiary(String userName);
    void login(LoginRequest loginRequest);
    void logOut(LogOutRequest logOutRequest);
    void UpdateEntry(UpdateRequest request);
    void createEntry(EntryCreateRequest entry);
    void deleteEntry(DeleteEntryRequest request);

    List<Entry> findEnteries(String userName);

}
