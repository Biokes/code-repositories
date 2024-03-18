package services;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import dtos.DiaryLoginRequest;

public class DiaryAppService implements DiaryServices{
    private DiaryRepository diaryRepository = new DiaryImp();
    @Override
    public Diary createDiary(DiaryLoginRequest loginRequest){
        Diary diary = new Diary();
        Diary savedDiary =  diaryRepository.save(diary);
        return savedDiary;
    }
        @Override
    public void deleteDiary(String userName){

    }

    @Override
    public long getDiariesSize(){
        return diaryRepository.count();
    }
}
