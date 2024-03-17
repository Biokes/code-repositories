package services;

import data.models.Diary;
import data.repositories.DiaryRepository;

public class DiaryAppService implements DiaryServices{
    private final DiaryRepository diaryRepository;
    public DiaryAppService(DiaryRepository diaryRepository){
        this.diaryRepository = diaryRepository;
    }
    @Override
    public Diary createDiary(String userName, String password){
        Diary diary = new Diary(userName);
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
