package com.helloworld.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.helloworld.R;

public class AFragment extends Fragment {

    private TextView mTvTitle;
    private Button mBtnChange, mBtnReset;
    private BFragment bFragment;

    public static AFragment newInstance(String title) {
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d("AFragment","---onCreateView---");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mBtnChange = (Button) view.findViewById(R.id.btn_change);
        mBtnReset = (Button) view.findViewById(R.id.btn_reset);
//        if(getActivity() != null){
//            do something
//        }else{
//
//        }

        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                Fragment fragment  = getFragmentManager().findFragmentByTag("a");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getArguments() != null) {
                    mTvTitle.setText("我是新文字");
                }
            }
        });

        if (getArguments() != null) {
            mTvTitle.setText(getArguments().getString("title"));
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //取消异步
    }
}

