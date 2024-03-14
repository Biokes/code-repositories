package test;

import data.models.Diary;
import data.repositories.DiaryImp;
import org.junit.Test;

public class DiaryDerosiroryTest{
    @Test
    public void addOneDiary_testOneISAdded(){
        DiaryImp diaryImp = new DiaryImp();
        Diary diary = new Diary();
        diaryImp.save(diary);

    }
}
