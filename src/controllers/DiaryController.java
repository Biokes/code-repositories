package controllers;

import dtos.RegisterDiary;
import services.DiaryServiceImpo;
import services.DiaryServices;

public class DiaryController{
    public String createDiary(RegisterDiary request){
         services.createDiary(request);
         return null;
    }
    private DiaryServices services = new DiaryServiceImpo();
}
