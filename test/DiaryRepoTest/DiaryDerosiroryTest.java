package DiaryRepoTest;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;

public class DiaryDerosiroryTest{
    @Test
    public void addOneDiary_testOneISAdded(){
        DiaryRepository diaryImp = new DiaryImp();
        Diary diary = new Diary();
        diaryImp.save(diary);
        assertEquals(1,diaryImp.count());
    }
    @Test
    public void addTwowDiary_testTwoISAdded(){
        DiaryRepository diaryImp = new DiaryImp();
        Diary diary = new Diary();
        diaryImp.save(diary);
        diaryImp.save(diary);
        assertEquals(2,diaryImp.count());
    }
    @Test
    public void test_AddTwoDiaries_removeOne(){
        DiaryRepository diaryImp = new DiaryImp();
        Diary diary = new Diary();
        diaryImp.save(diary);
        assertEquals(1,diaryImp.count());
        diaryImp.delete(diary);
        assertEquals(0,diaryImp.count());
    }
    @Test
    public void test_addDiary_findAllDiaries_assertLengthOFGottenDiaries(){
        DiaryRepository diaryImp = new DiaryImp();
        Diary diary = new Diary();
        for(int number = 0; number< 5; number++)
            diaryImp.save(diary);
        assertEquals(5,diaryImp.count());
        assertEquals(5, diaryImp.findAll().size());
    }
    @Test
    public void testDiaryCanBefoundByUserName(){
        Diary diary = new Diary();
        diary.setUsername("name");
        diary.setPassword("password");
        DiaryRepository repo = new DiaryImp();
        repo.save(diary);
        assertEquals(diary, repo.findDiary("name"));
    }
    @Test
    public void deleteDiaryByUserName_testDiaryIsDeleted(){
        Diary diary = new Diary();
        diary.setUsername("name");
        diary.setPassword("password");
        DiaryRepository repo = new DiaryImp();
        repo.save(diary);
        assertEquals(1, repo.count());
        assertEquals(diary, repo.findDiary("name"));
        repo.deleteDiary("name");
        assertEquals(0, repo.count());
    }
}
