package com.xuj.newtools.NetEaseMusic.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.xuj.newtools.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.search_edittext)
    EditText mSearchEdittext;
    @BindView(R.id.activity_search)
    RelativeLayout mActivitySearch;
    @BindView(R.id.search_toolbar)
    Toolbar mSearchToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mSearchToolbar.setTitle("");
        setSupportActionBar(mSearchToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        mSearchToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
