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
    @Override
    public Entry findById(String title){
        for( Entry entry: entries){
            if(entry.getTitle().equalsIgnoreCase(title))
                return entry;
        }
        return null;
    }
    public Entry findById(int id){
        for(Entry entry : entries)
            if(entry.getId() == id)
                return entry;
        return null;
    }
    public long count(){

        return entries.size();
    }

    @Override
    public boolean delete(int id){
        for(Entry entry : entries){
            if(entry.getId() == id)
                entries.remove(entry);
        return true;
        }
        return false;
    }

    public void delete(String title){
        entries.removeIf(entry -> entry.getTitle().equalsIgnoreCase(title));
    }
    public void delete(Entry entryGiven){
        for(Entry entry : entries)
            if(entry == entryGiven){
                entries.remove(entryGiven);
                break;
            }
    }
}
