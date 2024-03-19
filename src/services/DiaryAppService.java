package services;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import dtos.CreateDiaryRequest;
import exceptions.DiaryNotFoundException;
import exceptions.InvalidDetailsException;
import exceptions.UserAlreadyExistException;

public class DiaryAppService implements DiaryServices{
    private final DiaryRepository diaryRepository = new DiaryImp();
    private void validateRequest(CreateDiaryRequest loginRequest){
        if(loginRequest.getUserName().trim().isEmpty())
            throw new InvalidDetailsException();
        if(loginRequest.getPassword().trim().isEmpty())
            throw new InvalidDetailsException();
    }
    @Override
    public Diary createDiary(CreateDiaryRequest loginRequest){
        validateRequest(loginRequest);
        Diary diary = new Diary();
        diary.setUsername(loginRequest.getUserName());
        diary.setPassword(loginRequest.getPassword());
        validate(diary);
        return diaryRepository.save(diary);
    }

    private void validate(Diary diary){
        if( diaryRepository.findDiary(diary.getUsername()))
            throw new UserAlreadyExistException();
    }

    public void deleteDiary(String userName){
        if(diaryRepository.findDiary(userName)){
            diaryRepository.deleteDiary(userName);
            return;
        }
        throw new DiaryNotFoundException();
    }
    @Override
    public long count(){
        return diaryRepository.count();
    }
}
