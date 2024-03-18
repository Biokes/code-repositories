package diaryServicesTest;

import data.models.Diary;
import data.repositories.DiaryImp;
import data.repositories.DiaryRepository;
import dtos.DiaryLoginRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryAppService;
import services.DiaryNotFoundException;
import services.DiaryServices;

import static org.junit.jupiter.api.Assertions.*;

class DiaryAppServiceTest{
    DiaryRepository diaryRepository;
    DiaryAppService diaryAppService;

    @BeforeEach
    private void initialize(){
        diaryRepository = new DiaryImp();
        diaryAppService = new DiaryAppService(diaryRepository);
    }

    @Test
    public void createDiary(){
        DiaryLoginRequest login = new DiaryLoginRequest();
        Diary diary = diaryAppService.createDiary(login);
        assertEquals(0, diary.numberOfEntries());
    }
    @Test
    void deleteDiary(){
        DiaryServices diary = new DiaryAppService(diaryRepository);
        assertEquals(0,diary.getDiariesSize());
        assertThrows(DiaryNotFoundException.class ,()->diary.deleteDiary("user"));
    }




}