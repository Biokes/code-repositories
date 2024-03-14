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
    public void findDiaryUserName_diaryIsGotten(){
        DiaryImp diaryImp = new DiaryImp();
        Diary diary = new Diary("username");
        diary = diaryImp.save(diary);
        assertEquals(diary, diaryImp.findById("username"));

    }
}
