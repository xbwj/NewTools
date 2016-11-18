package com.xuj.newtools.NetEaseMusic.InnerFragmetn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuj.newtools.R;


/**
 * Created by Limuyang on 2016/7/8.
 */
public class PartnerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_partner, container, false);
        return v;
    }
}
