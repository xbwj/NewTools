package com.xuj.newtools.NetEaseMusic.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.xuj.newtools.R;
import com.xuj.newtools.NetEaseMusic.Fragment.DiscoFragment;
import com.xuj.newtools.NetEaseMusic.Fragment.FriendFragment;
import com.xuj.newtools.NetEaseMusic.Fragment.MusicFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.xuj.newtools.R.id.bar_disco;
import static com.xuj.newtools.R.id.bar_friends;
import static com.xuj.newtools.R.id.bar_music;

/**
 * Created by Administrator on 2016/11/10.
 */

public class ToolBarActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    TabLayout mTabLayout;
    private boolean isOpen;
    private long time = 0;

    @BindView(bar_disco)
    ImageView mBarDisco;
    @BindView(bar_music)
    ImageView mBarMusic;
    @BindView(bar_friends)
    ImageView mBarFriends;
    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.mainViewPager)
    ViewPager mMainViewPager;
    @BindView(R.id.lv_left_menu)
    ListView mLvLeftMenu;
    @BindView(R.id.drawLayout_left)
    DrawerLayout mDrawLayoutLeft;
    private ActionBarDrawerToggle mDrawerToggle;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private MyFragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        ButterKnife.bind(this);

        initData();
        initToolBar();
    }

    private void initData() {
        addFragment();
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mMainViewPager.setAdapter(mAdapter);
        mMainViewPager.setOnPageChangeListener(this);
        mBarDisco.setOnClickListener(this);
        mBarFriends.setOnClickListener(this);
        mBarMusic.setOnClickListener(this);
        mBarDisco.setSelected(true);
        mMainViewPager.setCurrentItem(0);
    }

    private void addFragment() {
        mFragmentList.add(new DiscoFragment());
        mFragmentList.add(new MusicFragment());
        mFragmentList.add(new FriendFragment());
    }

    private void initToolBar() {


        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawLayoutLeft, mToolBar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                isOpen = true;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                isOpen = false;
            }
        };
        mDrawerToggle.syncState();
        mDrawLayoutLeft.setDrawerListener(mDrawerToggle);
        mToolBar.setOnMenuItemClickListener(mOnMenuItemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    private Toolbar.OnMenuItemClickListener mOnMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Intent intent = new Intent();
            switch (item.getItemId()) {
                case R.id.menu_search:

                    intent.setClass(ToolBarActivity.this, SearchActivity.class);
                    startActivity(intent);
                    break;
            }
            return true;
        }

    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case bar_disco:
                mBarDisco.setSelected(true);
                mBarFriends.setSelected(false);
                mBarMusic.setSelected(false);
                mMainViewPager.setCurrentItem(0);
                break;
            case R.id.bar_music:
                mBarDisco.setSelected(false);
                mBarFriends.setSelected(false);
                mBarMusic.setSelected(true);
                mMainViewPager.setCurrentItem(1);
                break;
            case bar_friends:
                mBarDisco.setSelected(false);
                mBarFriends.setSelected(true);
                mBarMusic.setSelected(false);
                mMainViewPager.setCurrentItem(2);
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mBarDisco.setSelected(true);
                mBarFriends.setSelected(false);
                mBarMusic.setSelected(false);
                break;
            case 1:
                mBarDisco.setSelected(false);
                mBarFriends.setSelected(false);
                mBarMusic.setSelected(true);
                break;
            case 2:
                mBarDisco.setSelected(false);
                mBarFriends.setSelected(true);
                mBarMusic.setSelected(false);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mDrawLayoutLeft.isDrawerOpen(Gravity.LEFT)) {
                mDrawLayoutLeft.closeDrawers();
                isOpen = false;
                return true;
            } else {
                if ((System.currentTimeMillis() - time > 1000)) {
                    Toast.makeText(this, "再按一次返回桌面", Toast.LENGTH_SHORT).show();
                    time = System.currentTimeMillis();
                } else {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    startActivity(intent);
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
