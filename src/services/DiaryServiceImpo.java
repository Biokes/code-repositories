package services;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import dtos.RegisterDiary;
import exceptions.DiaryNotFoundException;
import exceptions.InvalidDetailsException;
import exceptions.UserAlreadyExistException;

public class DiaryServiceImpo implements DiaryServices{
    public void createDiary(RegisterDiary request){
        validate(request);
        Diary diary = new Diary();
        diary.setUsername(request.getUserName());
        diary.setPassword(request.getPassword( ));
        diary.logOut(false);
        diaryRepository.save(diary);
    }
    public long count(){
        return diaryRepository.count();
    }
    public Diary findDiary(String userName){
        if(isExisting(userName))
            throw new DiaryNotFoundException();
        return diaryRepository.findDiary(userName);
    }
    private void validate(RegisterDiary request){
        validateFields(request);
        if(findDiary(request.getUserName( )) != null)
            throw new UserAlreadyExistException();
    }
    private void validateFields(RegisterDiary request){
        if(request.getUserName().isEmpty())
            throw new InvalidDetailsException();
        if(request.getPassword().isEmpty())
            throw new InvalidDetailsException();
    }
    private boolean isExisting(String userName){
        if(findDiary(userName) == null)
            return false;
        return true;
    }
    private final DiaryRepository diaryRepository = new DiaryImp();
}
