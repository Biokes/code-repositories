package data.repositories;
import data.models.Diary;
import java.util.List;

public interface DiaryRepository{
Diary save(Diary diary);
List<Diary> findAll();
long count();
void delete(Diary diary);
void deleteDiary(String username);
Diary findDiary(String username);

}
