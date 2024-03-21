package services;

import data.models.Entry;
import dtos.DeleteEntryRequest;
import dtos.EntryCreateRequest;
import dtos.UpdateRequest;

import java.util.List;

public class EntryServicesmpo implements EntryServices{
    @Override
    public Entry createEntry(EntryCreateRequest request){
        return null;
    }

    @Override
    public void deleteEntry(DeleteEntryRequest request){

    }

    @Override
    public List<Entry> findEntries(String username){
        return null;
    }

    @Override
    public void updateEntry(UpdateRequest updateRequest){

    }
}
