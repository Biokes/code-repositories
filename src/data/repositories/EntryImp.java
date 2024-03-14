package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.List;

public class EntryImp implements EntryRepository{
    @Override
    public Diary save(Diary diary){
        return null;
    }

    @Override
    public Entry save(Entry entry){
        return null;
    }

    @Override
    public List<Entry> findAll(){
        return null;
    }

    @Override
    public Entry findById(int id){
        return null;
    }

    @Override
    public long count(){
        return 0;
    }

    @Override
    public void delete(int id){

    }

    @Override
    public void delete(Entry entry){

    }
}
