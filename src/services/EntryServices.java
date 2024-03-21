package services;

import data.models.Entry;
import dtos.DeleteEntryRequest;
import dtos.EntryCreateRequest;
import dtos.UpdateRequest;

import java.util.List;

public interface EntryServices{
    Entry createEntry(EntryCreateRequest request);
    void deleteEntry(DeleteEntryRequest request);
    List<Entry> findEntries(String username);
    void updateEntry(UpdateRequest updateRequest);
}
