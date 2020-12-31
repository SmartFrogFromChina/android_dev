package com.frog.ui.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.frog.ui.R;
import com.frog.ui.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivityRecyclerView extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<User> dataItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler_view);

        mRecyclerView = findViewById(R.id.rv_show);

        int i =0;
        for(i=0;i <20;i++){
            User user = new User();
            user.setYid("1111"+i);
            user.setImg("https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoDwdReicT8VDGbOHaWrFudYqTlPlzNZhy2IPrdiaRRwicV2bVxcIiaYRONKbKvuVTiaYlWC9TAAibziagaA/132");
            user.setNickname(i+"");
            user.setCash(i+0.5);
            user.setCoin(10*i+i);

            dataItems.add(user);
        }


        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivityRecyclerView.this));
        mRecyclerView.setAdapter(new ThunderUserAdapter(MainActivityRecyclerView.this,dataItems));

    }


}