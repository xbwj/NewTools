package com.xuj.newtools.NetEaseMusic.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuj.newtools.R;
import com.xuj.newtools.NetEaseMusic.InnerFragmetn.AnchorFragment;
import com.xuj.newtools.NetEaseMusic.InnerFragmetn.ListFragment;
import com.xuj.newtools.NetEaseMusic.InnerFragmetn.RankingFragment;
import com.xuj.newtools.NetEaseMusic.InnerFragmetn.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DiscoFragment extends Fragment {

    @BindView(R.id.disco_tabLayout)
    TabLayout mDiscoTabLayout;
    @BindView(R.id.disco_viewPager)
    ViewPager mDiscoViewPager;
    private List<Fragment> mFragmentList = new ArrayList<>(4);
    private List<String> mTitleList = new ArrayList<>(4);
    private RecommendFragment recommendFragment;
    private ListFragment listFragment;
    private AnchorFragment anchorFragment;
    private RankingFragment rankingFragment;
    private MyAdapter mAdapter;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_disco, container, false);

        ButterKnife.bind(this, layout);
        initData();
        return layout;
    }

    private void initData() {
        addFragment();
        mAdapter = new MyAdapter(getFragmentManager());
        mAdapter.notifyDataSetChanged();
        mDiscoViewPager.setAdapter(mAdapter);
        mDiscoViewPager.setOffscreenPageLimit(2);
        mDiscoTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mDiscoTabLayout.setupWithViewPager(mDiscoViewPager);

    }

    private void addFragment() {
        mTitleList.add("个性推荐");
        mTitleList.add("歌单");
        mTitleList.add("主播电台");
        mTitleList.add("排行榜");
        if (recommendFragment == null) {
            recommendFragment = new RecommendFragment();
            mFragmentList.add(recommendFragment);
        }
        if (listFragment == null) {
            listFragment = new ListFragment();
            mFragmentList.add(listFragment);
        }
        if (anchorFragment == null) {
            anchorFragment = new AnchorFragment();
            mFragmentList.add(anchorFragment);
        }
        if (rankingFragment == null) {
            rankingFragment = new RankingFragment();
            mFragmentList.add(rankingFragment);
        }
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
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

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }
}
