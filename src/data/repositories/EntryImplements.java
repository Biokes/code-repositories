package data.repositories;

import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryImplements implements EntryRepository{

    @Override
    public Entry save(Entry entry){
        entryRepo.add(entry);
        return entry;
    }

    @Override
    public List<Entry> findAll(){
        return null;
    }

    @Override
    public Entry findByTitle(String title){
        return null;
    }

    @Override
    public Entry findById(int id){
        return null;
    }

    @Override
    public long count(){
        return entryRepo.size();
    }

    @Override
    public boolean deleteById(int id){
        return false;
    }

    @Override
    public boolean deleteByEntry(Entry entry){
        return false;
    }

    @Override
    public Entry findEntriesByTitle(String title){
        return null;
    }

    @Override
    public Entry findEntryByAuthour(String author){
        return null;
    }
    private List<Entry> entryRepo = new ArrayList<>();
}