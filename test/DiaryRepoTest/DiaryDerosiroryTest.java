package DiaryRepoTest;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
    public void test_addMultipleDiary_removeDiary(){
        DiaryRepository diaryImp = new DiaryImp();
        Diary diary = new Diary();
        for(int number = 0; number< 5; number++)
            diaryImp.save(diary);
        assertEquals(5,diaryImp.count());
        diaryImp.delete(diary);
        diaryImp.delete(diary);
        diaryImp.delete(diary);
        diaryImp.delete(diary);
        assertEquals(1, diaryImp.count());
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

}
