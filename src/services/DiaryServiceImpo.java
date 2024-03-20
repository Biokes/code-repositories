package services;

import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import dtos.RegisterDiary;

public class DiaryServiceImpo implements DiaryServices{
    @Override
    public void createDiary(RegisterDiary request){

    }

    @Override
    public long count(){
        return diaryRepository.count();
    }

    private final DiaryRepository diaryRepository = new DiaryImp();
}
