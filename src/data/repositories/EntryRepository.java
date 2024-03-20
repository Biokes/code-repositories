package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.List;

public interface EntryRepository{
    Entry save(Entry entry);
    List<Entry> findAll();
    Entry findByTitle(String title);
    Entry findById(int id);
    long count();
    boolean deleteById(int id);
    boolean deleteByEntry(Entry entry);
    Entry findEntriesByTitle(String title);
    Entry findEntryByAuthour(String author);
}
