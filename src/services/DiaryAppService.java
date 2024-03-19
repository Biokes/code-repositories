package services;
import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import dtos.CreateDiaryRequest;
import dtos.DiaryLoginRequest;
import dtos.EntryRequest;
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
    public Diary register(CreateDiaryRequest loginRequest){
        validateRequest(loginRequest);
        Diary diary = new Diary();
        diary.setUsername(loginRequest.getUserName());
        diary.setPassword(loginRequest.getPassword());
        validate(diary);
        return diaryRepository.save(diary);
    }
    private void validate(Diary diary){
        if(diaryRepository.findDiary(diary.getUsername())!= null )
            throw new UserAlreadyExistException();
    }
    public void deleteDiary(String userName){
        if(isDiaryExisting(userName)){
            diaryRepository.deleteDiary(userName);
            return;
        }
        throw new DiaryNotFoundException();
    }
    @Override
    public long count(){
        return diaryRepository.count();
    }
    @Override
    public void addEntry(EntryRequest entryRequest){

    }

    @Override
    public void lockDiary(){

    }

    @Override
    public void login(DiaryLoginRequest loginRequest){
      Diary diary =  diaryRepository.findDiary(loginRequest.getUserName( ));
      diary.setLock(true);
    }

    @Override
    public void logOut(){

    }

    @Override
    public void delete(Diary diary){

    }

    @Override
    public Diary findDiary(String username){
        return null;
    }

    @Override
    public boolean isDiaryExisting(String username){
        for(Diary diary1 : diaryRepository.findAll())
            if(diary1.getUsername().equalsIgnoreCase(username))
                return true;
        return false;
    }


}
