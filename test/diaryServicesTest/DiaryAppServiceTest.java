package diaryServicesTest;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryAppService;

import static org.junit.jupiter.api.Assertions.*;

class DiaryAppServiceTest{
    DiaryRepository diaryRepository;
    DiaryAppService diaryAppService;

    @BeforeEach
            private void setUp(){
        diaryRepository = new DiaryImp();
        diaryAppService = new DiaryAppService(diaryRepository);
    }

    @Test
    public void createDiary(){
        Diary diary = diaryAppService.createDiary("Biokes diary", "biokes");
        System.out.println(diary );
        assertNotNull(diary);
    }
    @Test
    public void countDiarySize(){
        Diary diary = diaryAppService.createDiary("Biokes diary", "biokes");
        long size =diaryAppService.getDiariesSize( );
        assertEquals(1, size);
    }




}