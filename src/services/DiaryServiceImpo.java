package services;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import dtos.RegisterDiary;
import exceptions.UserAlreadyExistException;

public class DiaryServiceImpo implements DiaryServices{
    public void createDiary(RegisterDiary request){
        validate(request);
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
    private void validate(RegisterDiary request){
        if(findDiary(request.getUserName( )) != null)
            throw new UserAlreadyExistException();
    }
    private void validateFields(RegisterDiary request){

    }
    private final DiaryRepository diaryRepository = new DiaryImp();
}
