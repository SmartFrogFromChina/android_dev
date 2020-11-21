package com.frog.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.frog.ui.R;

public class WaterFragment extends Fragment {

    private TextView mTextView;
    private Button mBtnSwitch;
    private Button nBtnChangeText;

    public static WaterFragment instance(String str)
    {
        Bundle bundle = new Bundle();
        bundle.putString("name",str);
        WaterFragment waterFragment = new WaterFragment();
        waterFragment.setArguments(bundle);
        return waterFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main_fragment_water,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.tv_fragment_water);
        mBtnSwitch = view.findViewById(R.id.btn_switch_fragment);
        nBtnChangeText = view.findViewById(R.id.btn_set_fragment_text);

        mBtnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FireFragment fireFragment = new FireFragment();
                getFragmentManager().beginTransaction().add(R.id.fl_container,fireFragment).addToBackStack(null).commitAllowingStateLoss();
            }
        });
        nBtnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("文字是新的");
            }
        });


        if(getArguments() != null)
        {
            mTextView.setText(getArguments().getString("name"));
        }else {
            mTextView.setText("我是大水");
        }



    }




}
