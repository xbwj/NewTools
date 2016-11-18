package com.xuj.newtools.NetEaseMusic.InnerFragmetn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuj.newtools.R;

/**
 * Created by Limuyang on 2016/7/7.
 * 个性推荐
 */
public class RecommendFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
