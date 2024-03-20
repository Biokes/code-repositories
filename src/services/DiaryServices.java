package services;


import data.models.Diary;
import dtos.RegisterDiary;

public interface DiaryServices{

    void createDiary(RegisterDiary request);

    long count();
    Diary findDiary(String userName);

}
