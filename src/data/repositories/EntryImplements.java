package data.repositories;

import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryImplements implements EntryRepository{

    public Entry save(Entry entry){
        entryRepo.add(entry);
        return entry;
    }
    public List<Entry> findAll(){
        return entryRepo;
    }

    public Entry findByTitle(String title){
        for(Entry entry : entryRepo)
            if(entry.getTitle().equalsIgnoreCase( title ))
                return entry;
        return null;
    }

    public Entry findById(int id){
        for(Entry entry : entryRepo)
            if(entry.getId() ==  id )
                return entry;
        return null;
    }
    public long count(){
        return entryRepo.size();
    }
    public boolean deleteById(int id){
        for(Entry entry : entryRepo)
            if(entry.getId() == id ){
                entryRepo.remove(entry);
                return true;
            }
        return false;
    }

    @Override
    public boolean deleteByEntry(Entry entry){
        for(Entry entrygiven : entryRepo)
            if(entrygiven == entry){
                entryRepo.remove(entry);
                return true;
            }
        return false;
    }

    @Override
    public Entry findEntriesByTitle(String title){
        for(Entry entrygiven : entryRepo)
            if(entrygiven.getTitle().equalsIgnoreCase(title)){
             return entrygiven;
        }
        return null;
    }

    @Override
    public Entry findEntryByAuthour(String author){
        for(Entry entrygiven : entryRepo)
            if(entrygiven.getAuthor().equalsIgnoreCase(author)){
                return entrygiven;
            }
        return null;
    }
    private final List<Entry> entryRepo = new ArrayList<>();
}