package com.xuj.newtools.Demo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.xuj.newtools.Demo.fragment.MainFragment;
import com.xuj.newtools.R;

public class MainActivity extends AppCompatActivity {


    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.main_tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
//        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 1"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 2"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 3"));
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));


        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),
                this);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private String[] titles = new String[]{"头条", "要闻", "热点", "成都", "科技","云课堂","轻松一刻","跟帖","房产","段子"};

        public final int COUNT = titles.length;
        private Context context;

        public ViewPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return MainFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
