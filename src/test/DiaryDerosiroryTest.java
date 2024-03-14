package test;

import data.models.Diary;
import data.repositories.DiaryImp;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DiaryDerosiroryTest{
    @Test
    public void addOneDiary_testOneISAdded(){
        DiaryImp diaryImp = new DiaryImp();
        Diary diary = new Diary();
        diaryImp.save(diary);
        assertEquals(1,diaryImp.count());
    }
}
