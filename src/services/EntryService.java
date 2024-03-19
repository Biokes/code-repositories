package services;

import data.models.Entry;
import dtos.EntryRequest;

public interface EntryService{
    Entry createEntry(EntryRequest request);
    void deleteEntry(Entry entry);
    int getNumberOfEnteries();
}

