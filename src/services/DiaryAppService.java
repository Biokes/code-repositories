package services;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import dtos.CreateDiaryRequest;

public class DiaryAppService implements DiaryServices{
    private final DiaryRepository diaryRepository = new DiaryImp();
    @Override
    public Diary createDiary(CreateDiaryRequest loginRequest){
        Diary diary = new Diary();
        return diaryRepository.save(diary);
    }
    @Override
    public void deleteDiary(String userName){
        diaryRepository.deleteDiary(userName);
    }
    @Override
    public long count(){
        return diaryRepository.count();
    }
}
