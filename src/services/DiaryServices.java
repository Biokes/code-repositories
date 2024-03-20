package services;


import dtos.RegisterDiary;

public interface DiaryServices{

    void createDiary(RegisterDiary request);

    long count();

}
