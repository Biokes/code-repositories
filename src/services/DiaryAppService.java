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
    public Diary findDiary(String username){
        if(isDiaryExisting(username))
            return diaryRepository.findDiary(username);
        throw new DiaryNotFoundException();
    }
    public boolean isDiaryExisting(String username){
        for(Diary diary1 : diaryRepository.findAll())
            if(diary1.getUsername().equalsIgnoreCase(username))
                return true;
        return false;
    }
    private void validateRequest(CreateDiaryRequest loginRequest){
        if(loginRequest.getUserName().trim().isEmpty())
            throw new InvalidDetailsException();
        if(loginRequest.getPassword().trim().isEmpty())
            throw new InvalidDetailsException();
    }
    public Diary register(CreateDiaryRequest loginRequest){
        validateRequest(loginRequest);
        Diary diary = new Diary();
        diary.setUsername(loginRequest.getUserName());
        diary.setPassword(loginRequest.getPassword());
        validate(diary);
        return diaryRepository.save(diary);
    }
    private void validate(Diary diary){
        if(isDiaryExisting(diary.getUsername( )))
            throw new UserAlreadyExistException();
    }
    public void deleteDiary(String userName){
        if(isDiaryExisting(userName)){
            diaryRepository.deleteDiary(userName);
            return;
        }
        throw new DiaryNotFoundException();
    }
    public long count(){
        return diaryRepository.count();
    }
    public void login(DiaryLoginRequest loginRequest){
      if(loginRequest.getPassword().equals(diaryRepository.findDiary(loginRequest.getUserName( )).getPassword())){
          diaryRepository.findDiary(loginRequest.getUserName( )).setLock(true);
        return;
      }
      throw new InvalidDetailsException();
    }
    public void addEntry(EntryRequest entryRequest){

    }
    public void lockDiary(){

    }
    public void logOut(){

    }
    public void delete(Diary diary){

    }
}
