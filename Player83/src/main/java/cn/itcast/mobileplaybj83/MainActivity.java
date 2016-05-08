package cn.itcast.mobileplaybj83;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.itcast.mobileplaybj83.adapter.VideoFragmentAdapter;
import cn.itcast.mobileplaybj83.ui.activity.BaseActivity;
import cn.itcast.mobileplaybj83.ui.fragment.AudioFragment;
import cn.itcast.mobileplaybj83.ui.fragment.VideoFragment;

public class MainActivity extends BaseActivity {

    private TextView main_tab_video;
    private TextView main_tab_audio;
    private ImageView main_indicate;
    private ViewPager main_viewpager;
    private ArrayList<Fragment> fragmentList;
    private VideoFragmentAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    public void initData() {
        fragmentList.add(new VideoFragment());
        fragmentList.add(new AudioFragment());
        adapter.notifyDataSetChanged();
        /*初始化指示器宽度*/
        main_indicate.getLayoutParams().width = getWindowManager().getDefaultDisplay().getWidth()/fragmentList.size();
    }

    @Override
    public void initListener() {
        main_tab_video.setOnClickListener(this);
        main_tab_audio.setOnClickListener(this);
        main_viewpager.setOnPageChangeListener(new MyOnPageChangeListener());
        fragmentList = new ArrayList<>();
        adapter = new VideoFragmentAdapter(getSupportFragmentManager(),fragmentList);
        main_viewpager.setAdapter(adapter);
    }

    @Override
    public void initView() {
        main_tab_video = (TextView) findViewById(R.id.main_tab_video);
        main_tab_audio = (TextView) findViewById(R.id.main_tab_audio);
        main_indicate = (ImageView) findViewById(R.id.main_indicate);
        main_viewpager = (ViewPager) findViewById(R.id.main_viewpager);
    }

    @Override
    public void pressClick(View v) {
        switch (v.getId()){
            case R.id.main_tab_video:
                main_viewpager.setCurrentItem(0);
                break;
            case R.id.main_tab_audio:
                main_viewpager.setCurrentItem(1);
                break;
        }
    }


    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        /*当页面滑动时回调*/
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            ViewCompat.setTranslationX(main_indicate,main_indicate.getWidth()*(position + positionOffset));
        }

        @Override
        /*当页面选中后回调*/
        public void onPageSelected(int position) {
            updataTabs(position);
        }
        @Override
        /*当页面滑动状态发生变化时回调*/
        public void onPageScrollStateChanged(int state) {

        }
    }

    private void updataTabs(int position) {
        updataTab(0,position,main_tab_video);
        updataTab(1,position,main_tab_audio);
    }

    /*跟新tab状态*/
    private void updataTab(int i, int position, TextView tab) {
        int greed = getResources().getColor(R.color.greed);
        int halfwhite = getResources().getColor(R.color.halfwhite);
        if(i==position){
            /*选中状态，高亮*/
            tab.setTextColor(greed);
            ViewCompat.animate(tab).scaleX(1.2f).scaleY(1.2f);
        }else{
            /*默认状态，灰色*/
            tab.setTextColor(halfwhite);
            ViewCompat.animate(tab).scaleX(1.0f).scaleY(1.0f);
        }
    }
}
