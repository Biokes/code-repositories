package services;

import data.models.Entry;
import data.repositories.EntryImplements;
import data.repositories.EntryRepository;
import dtos.EntryRequest;
import exceptions.InvalidDetailsException;

public class EntryServiceImpo implements EntryService{
    public void createEntry(EntryRequest request){
        Entry entry = new Entry();
        entry.setAuthor(request.getUserName());
        entry.setTitle(request.getTitle());
        entry.setId((int)entriesRepo.count()+ 1);
        entry.setBody(request.getBody());
        entriesRepo.save(entry);
    }
    @Override
    public void deleteEntry(int id){
       if(!entriesRepo.delete(id))
           throw new InvalidDetailsException();
    }

    @Override
    public Entry findEntryById(int id){
        return null;
    }

    public Entry findEntryByTitle(String title){
       if(entriesRepo.findById(title)== null)
           throw new InvalidDetailsException();
       return entriesRepo.findById(title);
    }

    public long getNumberOfEnteries(){
        return entriesRepo.count();
    }
    private EntryRepository entriesRepo = new EntryImplements();
}
