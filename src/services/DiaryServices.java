package services;


import data.models.Diary;
import data.models.Entry;
import dtos.RegisterDiary;

public interface DiaryServices{

    void createDiary(RegisterDiary request);

    long count();
    Diary findDiary(String userName);
    void login();
    void logOut();
    void UpdateEntry();
    Entry createEntry();
    void deleteEntry();
}
