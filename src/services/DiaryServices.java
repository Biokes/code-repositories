package services;


import data.models.Diary;
import data.models.Entry;
import dtos.*;

import java.util.List;

public interface DiaryServices{

    void createDiary(RegisterDiary request);

    long count();
    Diary findDiary(String userName);
    void login();
    void logOut(LogOutRequest logOutRequest);
    void UpdateEntry(UpdateRequest request);
    Entry createEntry(Entry entry);
    void deleteEntry(DeleteEntryRequest request);

    List<Entry> findEnteries(String userName);

}
