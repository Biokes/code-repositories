package data.repositories;
import data.models.Diary;
import java.util.ArrayList;
import java.util.List;
public class DiaryImp implements DiaryRepository{
    private final List<Diary> diaries = new ArrayList<>();
    public Diary save(Diary diary){
        diaries.add(diary);
        return diary;
    }
    public List<Diary> findAll(){
        return this.diaries;
    }
    public Diary findById(String username){
        for(Diary diary : diaries)
            if(diary.getUsername().equals(username))
                return diary;
        return null;
    }
    public long count(){
        return diaries.size( );
    }
    public void delete(Diary diary){
        diaries.removeIf(diary1-> diary1 == diary);
    }
    public void deleteDiary(String username){
        diaries.removeIf(currentDiary-> currentDiary.getUsername().equalsIgnoreCase(username));
    }


}
