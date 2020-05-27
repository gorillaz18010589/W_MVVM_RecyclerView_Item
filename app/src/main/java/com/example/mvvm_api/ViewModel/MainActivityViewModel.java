package com.example.mvvm_api.ViewModel;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_api.Model.NicePlace;
import com.example.mvvm_api.Repository.NicePlaceRespository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {


    //1.宣告
    private MutableLiveData<List<NicePlace>> mutableLiveData;
    private NicePlaceRespository mRepo; //自己寫的Responsitory處理資料
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    //3.初始化資料庫
    public void init(){
        //如果初始化了結束
        if(mutableLiveData != null){
            return;
        }
        //沒有初始化的話,初始化資料物件,並取得物件實體
        mRepo = new NicePlaceRespository().getInstance();
        mutableLiveData = mRepo.getNicePleaces();
    }

    //4.更新apdapter資料 (新增圖片跟title方法)
    public void addNewValue(final NicePlace nicePlace) {
        //設定為true
        mIsUpdating.setValue(true);

        //背景執行續設定
        new AsyncTask<Void, Void, Void>() {
            //執行前可以在這邊設定
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //將帶入的新Niceplaec物件,變成新的
                List<NicePlace> currentPlaces = mutableLiveData.getValue(); //取得現在的bean,放入新的
                currentPlaces.add(nicePlace); //新增一個使用者放入的bean
                mutableLiveData.postValue(currentPlaces); //更新資料
                mIsUpdating.postValue(false); //更新按鈕為flase 開關概念
            }

            //執行中在背景做事情
            @Override
            protected Void doInBackground(Void... voids) {
                try{
                    Thread.sleep(2000); //2秒一次
                }catch (Exception e){

                }
                return null;
            }
        }.execute();
    }

    //2.取得物件實體
    public MutableLiveData<List<NicePlace>> getMutableLiveData() {
        return mutableLiveData;
    }


    //3.取得MutableLiveData<Boolean>物件實體
    public MutableLiveData<Boolean> getmIsUpdating() {
        return mIsUpdating;
    }
}
