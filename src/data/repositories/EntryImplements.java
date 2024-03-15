package data.repositories;

import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryImplements implements EntryRepository{
    private final List<Entry> entries = new ArrayList<>();
    public Entry save(Entry entry){
        entries.add(entry);
        return entry;
    }
    public List<Entry> findAll(){
        return entries;
    }

    public Entry findById(int id){
        for( Entry entry: entries){
            if(entry.getId() == id)
                return entry;
        }
        return null;
    }
    public long count(){

        return entries.size();
    }
    public void delete(int id){
        entries.remove(findById(id));
    }
    public void delete(Entry entryGiven){
        for(Entry entry : entries)
            if(entry == entryGiven){
                entries.remove(entryGiven);
                break;
            }
    }
}