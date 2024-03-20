package services;

import data.models.Entry;
import dtos.EntryRequest;

public interface EntryService{
    void createEntry(EntryRequest request);
    void deleteEntry(int id);
    Entry findEntryById(int id);
    long getNumberOfEnteries();
}

