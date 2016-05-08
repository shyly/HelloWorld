package come.google.voideplayer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/7.
 * --------- 日期 ------- 维护人 ------------ 变更内容 --------
 * 2016/5/7		  Administrator			新增Person类
 * 2016/5/7		  Administrator			增加sex属性
 */

public class VideoFragmentAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> fragments;
//
//    public VideoFragmentAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
//        super(fm);
//        this.fragments = fragments;
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        return fragments.get(position);
//    }
//
//    @Override
//    public int getCount() {
//        return getCount();
//    }
//    private final ArrayList<Fragment> fragments;

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

