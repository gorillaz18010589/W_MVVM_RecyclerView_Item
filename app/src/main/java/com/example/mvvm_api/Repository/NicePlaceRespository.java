package com.example.mvvm_api.Repository;
//這邊做資料傳送的演算

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_api.Model.NicePlace;
import com.example.mvvm_api.R;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRespository {

    private static NicePlaceRespository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    //1.如果沒有物件實體化,物件實體化後回傳
    public static NicePlaceRespository getInstance() {
        if (instance == null) {
            instance = new NicePlaceRespository();
        }
        return instance;
    }

    //2.Mut帶的物件資料結構,物件實體化設定值,這邊可以抓取網路資料api等
    public MutableLiveData<List<NicePlace>> getNicePleaces() {
        setNicePlaces(); //初始化將資料灌入adapter
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }


    //3.設定資料到Model方法
    public void setNicePlaces() {
        for (int i = 0; i < 10; i++) {
            dataSet.add(
                    new NicePlace("hello", R.drawable.ic_android_black_24dp)
            );
        }
    }

}
