package services;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import dtos.RegisterDiary;

public class DiaryServiceImpo implements DiaryServices{
    public void createDiary(RegisterDiary request){
        Diary diary = new Diary();
        diary.setUsername(request.getUserName());
        diary.setPassword(request.getPassword( ));
        diaryRepository.save(diary);
    }
    public long count(){
        return diaryRepository.count();
    }

    public Diary findDiary(String userName){
        return diaryRepository.findDiary(userName);
    }
    private final DiaryRepository diaryRepository = new DiaryImp();
}
