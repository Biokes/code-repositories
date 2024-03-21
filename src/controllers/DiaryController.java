package controllers;

import data.models.Diary;
import dtos.LogOutRequest;
import dtos.LoginRequest;
import dtos.RegisterDiary;
import services.DiaryServiceImpo;
import services.DiaryServices;

public class DiaryController{
    public String createDiary(RegisterDiary request){
        try{
            services.createDiary(request);
            return "Diary created Successfully.";
        }catch(RuntimeException exception){
            return "Invalid details Provided";
        }
    }
    private DiaryServices services = new DiaryServiceImpo();

    public int count(){
        return (int)services.count();
    }

    public String deleteDiary(LoginRequest request){
        Diary diary = new Diary();
        diary.setPassword(request.getPassword( ));
        diary.setUsername(request.getUserName( ));
        try{
            services.deleteDiary(request);
            return "Diary Deleted Successfully.";
        }catch(RuntimeException exception){
            return "Invalid details Provided";
        }
    }

    public String logOut(LogOutRequest logOutRequest){
        services.logOut(logOutRequest);
        return "Logged in successfully.";
    }

    public Diary findDiary(String userName){
        return services.findDiary(userName);
    }

    public String logIn(LoginRequest logOutRequest){
        services.login(logOutRequest);
        return "Logged out Successfully";
    }
}
