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
        return null;
    }

    @Override
    public Diary findById(String username){
        return null;
    }

    @Override
    public long count(){
        return diaries.size( );
    }

    @Override
    public void delete(Diary diary){

    }


}
