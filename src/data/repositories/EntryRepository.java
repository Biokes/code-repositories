package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.List;

public interface EntryRepository{
    Entry save(Entry entry);
    List<Entry> findAll();
    Entry findById(String title);
    long count();
    boolean delete(int id);
    void delete(Entry entry);
}
