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

    @Override
    public List<Diary> findAll(){
        return this.diaries;
    }

    @Override
    public Diary findById(String username){
        for(Diary diary : diaries)
            if(diary.getUsername().equals(username))
                return diary;
        return null;
    }

    @Override
    public long count(){

        return diaries.size( );
    }

    @Override
    public void delete(Diary diary){
        for(Diary diary1: diaries)
            if(diary1 == diary){
                diaries.remove(diary);
                break;
            }
    }

    @Override
    public void deleteDiary(String username){

    }


}
