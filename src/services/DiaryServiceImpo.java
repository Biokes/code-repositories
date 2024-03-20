package services;
import data.models.Diary;
import data.models.Entry;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import data.repositories.EntryImplements;
import data.repositories.EntryRepository;
import dtos.*;
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
    public void UpdateEntry(UpdateRequest request){

    }
    public Entry createEntry(Entry entry){
        entries.save(entry);
        return entry;
    }
    public void login(){

    }
    public void deleteEntry(DeleteEntryRequest request){

    }

    @Override
    public List<Entry> findEnteries(String userName){
        List<Entry> entriesFound = new ArrayList<>();
        for(int counter = 0; counter <entries.count() ; counter++)
            if(entries.findEntryByAuthour(userName).getAuthor().equalsIgnoreCase(userName))
                entriesFound.add(entries.findEntryByAuthour(userName));
        return entriesFound;
    }

    private final DiaryRepository diaryRepository = new DiaryImp();
    private final EntryRepository entries = new EntryImplements();
}
