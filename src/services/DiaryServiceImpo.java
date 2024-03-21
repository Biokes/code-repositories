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
        }
        else throw new InvalidDetailsException();
    }

    public void logOut(LogOutRequest logOutRequest){
        findDiary(logOutRequest.getUserName( )).logOut(true);
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
        List<Entry> entriesFound = new ArrayList<>();
        for(int counter = 0; counter <entries.count() ; counter++)
            if(entries.findEntryByAuthour(userName).getAuthor().equalsIgnoreCase(userName))
                entriesFound.add(entries.findEntryByAuthour(userName));
        return entriesFound;
    }
    public void createEntry(Entry entry){
        if(diaryRepository.findDiary(entry.getAuthor( )).isLocked())
            throw new DiaryIsLockedException();
        entries.save(entry);
    }

    public void UpdateEntry(UpdateRequest request){

    }
    public void deleteEntry(DeleteEntryRequest request){
        Entry entry = new Entry();
        entry.setAuthor(request.getUsername());
        entry.setTitle(request.getTitle( ));
        Diary diary = diaryRepository.findDiary(request.getUsername());
        if(!diary.isLocked()){
            if(diary.getUsername().equalsIgnoreCase(entry.getAuthor()) && diary.getPassword().equals(request.getPassword())){
                 entries.deleteByEntry(entry);
            }else throw new InvalidDetailsException();
        }else throw new DiaryIsLockedException();
    }
    private final DiaryRepository diaryRepository = new DiaryImp();
    private final EntryRepository entries = new EntryImplements();
}
