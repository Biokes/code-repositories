package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.List;

public interface EntryRepository{
    Diary save(Diary diary);
    Entry save(Entry entry);
    List<Entry> findAll();
    Entry findById(int id);
    long count();
    void delete(int id);
    void delete(Entry entry);
}