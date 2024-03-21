package services;
import data.models.Diary;
import data.models.Entry;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import data.repositories.EntryImplements;
import data.repositories.EntryRepository;
import dtos.*;
import exceptions.DiaryIsLockedException;
import exceptions.DiaryNotFoundException;
import exceptions.InvalidDetailsException;
import exceptions.UserAlreadyExistException;

import java.util.ArrayList;
import java.util.List;

public class DiaryServiceImpo implements DiaryServices{
    public void createDiary(RegisterDiary request){
        validate(request);
        Diary diary = new Diary();
        diary.setUsername(request.getUserName());
        diary.setPassword(request.getPassword( ));
        diary.logOut(false);
        diaryRepository.save(diary);
    }

    @Override
    public void deleteDiary(LoginRequest diary){
        if(findDiary(diary.getUserName( )).getPassword().equals(diary.getPassword()))
            diaryRepository.deleteDiary(diary.getUserName());
        else throw new DiaryNotFoundException();
    }

    public long count(){
        return diaryRepository.count();
    }
    public Diary findDiary(String userName){
        if(diaryRepository.findDiary(userName) == null)
            throw new DiaryNotFoundException();
        return diaryRepository.findDiary(userName);
    }
    public void login(LoginRequest loginRequest){
        if(diaryRepository.findDiary(loginRequest.getUserName( )).getPassword().equals(loginRequest.getPassword())){
            diaryRepository.findDiary(loginRequest.getUserName()).logOut(false);
            return;
        }
        else throw new InvalidDetailsException();
    }
    public void logOut(LogOutRequest logOutRequest){
        findDiary(logOutRequest.getUserName( )).logOut(true);
    }

    @Override
    public void UpdateEntry(UpdateRequest request){

    }

    @Override
    public void createEntry(Entry entry){

    }

    @Override
    public void deleteEntry(DeleteEntryRequest request){

    }

    private void validate(RegisterDiary request){
        validateFields(request);
        if(isExisting(request.getUserName( )))
            throw new UserAlreadyExistException();
    }
    private void validateFields(RegisterDiary request){
        if(request.getUserName().isEmpty())
            throw new InvalidDetailsException();
        if(request.getPassword().isEmpty())
            throw new InvalidDetailsException();
    }
    private boolean isExisting(String userName){
        return diaryRepository.findDiary(userName)!= null;
    }
    public List<Entry> findEnteries(String userName){
        return null;
    }

    private final DiaryRepository diaryRepository = new DiaryImp();
    private EntryRepository entries = new EntryImplements();
}
