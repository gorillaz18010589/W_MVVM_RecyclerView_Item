package com.example.mvvm_api;
//https://www.youtube.com/watch?v=ijXjCtCXcN4
//1.準備好葉面,跟recyclerView
//2.寫ViewModel
//3.mainActivityViewModel初始化
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.mvvm_api.Adapter.MainRecyclerAdapter;
import com.example.mvvm_api.Model.NicePlace;
import com.example.mvvm_api.ViewModel.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<NicePlace> nicePlaceList;
    private MainActivityViewModel mainActivityViewModel;
    private  MainRecyclerAdapter mainRecyclerAdapter;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nicePlaceList = new ArrayList<>();
        recyclerView = findViewById(R.id.rcyView);
        fab = findViewById(R.id.fab);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);


        //3.初始化資料冠資料進去
        mainActivityViewModel.init();

        //2.當getMutableLiveData質變時
        mainActivityViewModel.getMutableLiveData().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                mainRecyclerAdapter.notifyDataSetChanged(); //值變化時更新adaptey
            }
        });


        //4. true/false設定要不要顯示toolbar或引藏
        mainActivityViewModel.getmIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){

                }else{

                }
            }
        });

        //按下按鈕新增一個新的圖片跟title
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.addNewValue(
                        new NicePlace(
                                "hank", R.drawable.ic_insert_emoticon_black_24dp
                        )
                );
            }
        });

        initRecyclerView();

    }
    //1.初始化Adapter
    private void initRecyclerView() {
        mainRecyclerAdapter = new MainRecyclerAdapter(mainActivityViewModel.getMutableLiveData().getValue(),this); //這個Adapter設定這個Context,資料從MainViewModel里控制
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainRecyclerAdapter);
    }

}
