package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryImplements implements EntryRepository{
    private final List<Entry> entries = new ArrayList<>();
    @Override
    public Diary save(Diary diary){
        return null;
    }

    @Override
    public Entry save(Entry entry){
        entries.add(entry);
        return entry;
    }

    @Override
    public List<Entry> findAll(){
        return null;
    }

    public Entry findById(int id){
        return null;
    }
    public long count(){

        return entries.size();
    }
    public void delete(int id){

    }

    @Override
    public void delete(Entry entry){

    }
}
