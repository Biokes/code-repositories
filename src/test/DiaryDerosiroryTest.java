package test;

import data.models.Diary;
import data.repositories.DiaryImp;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DiaryDerosiroryTest{
    @Test
    public void addOneDiary_testOneISAdded(){
        DiaryImp diaryImp = new DiaryImp();
        Diary diary = new Diary("username");
        diaryImp.save(diary);
        assertEquals(1,diaryImp.count());
    }
    @Test
    public void addTwowDiary_testTwoISAdded(){
        DiaryImp diaryImp = new DiaryImp();
        Diary diary = new Diary("username");
        diaryImp.save(diary);
        diaryImp.save(diary);
        assertEquals(2,diaryImp.count());
    }
    @Test
    public void findDiaryByUserName_diaryIsGotten(){
        DiaryImp diaryImp = new DiaryImp();
        Diary diary = new Diary("username");
        diary = diaryImp.save(diary);
        assertEquals(diary, diaryImp.findById("username"));
    }
    @Test
    public void test_AddTwoDiaries_removeOne(){
        DiaryImp diaryImp = new DiaryImp();
        Diary diary = new Diary("username");
        diaryImp.save(diary);
        assertEquals(1,diaryImp.count());
        diaryImp.delete(diary);
        assertEquals(0,diaryImp.count());
    }
    @Test
    public void test_addMultipleDiary_removeDiary(){
        DiaryImp diaryImp = new DiaryImp();
        Diary diary = new Diary("username");
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
        DiaryImp diaryImp = new DiaryImp();
        Diary diary = new Diary("username");
        for(int number = 0; number< 5; number++)
            diaryImp.save(diary);
        assertEquals(5,diaryImp.count());
        assertEquals(5, diaryImp.findAll().size());
    }
    @Test
    public void test_deleteDiaryByUserName(){
        DiaryImp diaryImp = new DiaryImp();
        Diary diary = new Diary("username");
        for(int number = 0; number< 5; number++)
            diaryImp.save(diary);
        assertEquals(5,diaryImp.count());
        assertEquals(5, diaryImp.findAll().size());
        diaryImp.deleteDiary("username");
        assertEquals(4,diaryImp.count());
    }
    @Test
    public void test_addMultipleDiary_removeDiary_countDiary(){
        DiaryImp diaryImp=new DiaryImp( );
        Diary diary=new Diary("username");
        for( int number=0; number<5; number++ )
            diaryImp.save(diary);
        assertEquals(5, diaryImp.count( ));
        diaryImp.delete(diary);
        assertEquals(4, diaryImp.count( ));
    }
}
