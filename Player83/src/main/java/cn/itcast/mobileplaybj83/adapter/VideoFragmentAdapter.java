package cn.itcast.mobileplaybj83.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by flykozhang on 2016/5/6.
 */
public class VideoFragmentAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> fragments;

    public VideoFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
