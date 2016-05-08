package come.google.voideplayer;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import come.google.voideplayer.adapter.VideoFragmentAdapter;
import come.google.voideplayer.ui.Activity.BaseActivity;
import come.google.voideplayer.ui.Fragment.AudioFragment;
import come.google.voideplayer.ui.Fragment.VideoFragment;

public class MainActivity extends BaseActivity {

    private TextView main_tab_video;
    private TextView main_tab_audio;
    private ImageView main_indcate;
    private ViewPager main_viewpager;
    private ArrayList<Fragment> fragments;
    VideoFragmentAdapter adpter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
//        TextView main_tab_video = (TextView) findViewById(R.id.main_tab_video);
        main_tab_video = (TextView) findViewById(R.id.main_tab_video);
        main_tab_audio = (TextView) findViewById(R.id.main_tab_audio);
        main_indcate = (ImageView) findViewById(R.id.main_Indicate);
        main_viewpager = (ViewPager) findViewById(R.id.main_viewpager);
    }

    @Override
    public void initData() {

        fragments.add(new VideoFragment());
        fragments.add(new AudioFragment());
        adpter.notifyDataSetChanged();

        //初始化指示器的宽度，屏幕宽度的一半
        main_indcate.getLayoutParams().width=getWindowManager().getDefaultDisplay().getWidth()/fragments.size();
    }


    @Override
    public void initListener() {
        main_tab_video.setOnClickListener(this);
        main_tab_audio.setOnClickListener(this);

        fragments = new ArrayList<Fragment>();

        main_viewpager.addOnPageChangeListener(new MyOnPageChangeListener());

        adpter = new VideoFragmentAdapter(getSupportFragmentManager(),fragments);
        main_viewpager.setAdapter(adpter);
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

    private void updateTabs(int position) {
        updateTab(0,position,main_tab_video);
        updateTab(1,position,main_tab_audio);
    }

    private void updateTab(int i, int position, TextView tab) {
        int greed = getResources().getColor(R.color.greed);
        int halfwhite = getResources().getColor(R.color.halfwhite);
        if(i==position){
            tab.setTextColor(greed);
            ViewCompat.animate(tab).scaleX(1.2f).scaleY(1.2f);
        }else {
            tab.setTextColor(halfwhite);
            ViewCompat.animate(tab).scaleX(1.0f).scaleY(1.0f);
        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            ViewCompat.setTranslationX(main_indcate,main_indcate.getWidth()*(position+positionOffset));
        }

        @Override
        public void onPageSelected(int position) {
            updateTabs(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }
}
