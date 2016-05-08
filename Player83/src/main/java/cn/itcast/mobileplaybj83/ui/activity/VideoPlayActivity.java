package cn.itcast.mobileplaybj83.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import cn.itcast.mobileplaybj83.R;
import cn.itcast.mobileplaybj83.bean.VideoItem;
import cn.itcast.mobileplaybj83.utils.StringUtil;

/**
 * Created by flykozhang on 2016/5/6.
 */
public class VideoPlayActivity extends BaseActivity {

    private static final int MSG_UPDATA_SYSTEM_TIME = 0;
    private VideoItem item;
    private VideoView videoplay_videoview;
    private TextView videoplay_name;
    private TextView videoplay_systemtime;
    private ImageView videoplay_battery;
    private ImageView videoplay_iv_volume;
    private SeekBar videoplay_sk_volume;
    private TextView videoplay_position;
    private TextView videoplay_duration;
    private SeekBar videoplay_sk_position;
    private ImageView videoplay_exit;
    private ImageView videoplay_pre;
    private ImageView videoplay_play;
    private ImageView videoplay_next;
    private ImageView videoplay_full_screen;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case MSG_UPDATA_SYSTEM_TIME:
                    notifyUpdataSystem();
                    break;
            }
        }
    };
    private MyBroadcastReceiver receiver;
    private IntentFilter filter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_videoplay;
    }

    @Override
    public void initData() {
        item = (VideoItem) getIntent().getSerializableExtra("item");
        videoplay_videoview.setVideoURI(Uri.parse(item.getPath()));
        videoplay_name.setText(item.getTitle());
        notifyUpdataSystem();
    }

    @Override
    public void initListener() {
        videoplay_videoview.setOnPreparedListener(new MyOnPreparedListener());
        receiver = new MyBroadcastReceiver();
        filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        handler.removeCallbacksAndMessages(null);
    }

    /*通知更新系统时间*/
    private void notifyUpdataSystem() {
        videoplay_systemtime.setText(StringUtil.fromatSystemTime());
        handler.sendEmptyMessageDelayed(MSG_UPDATA_SYSTEM_TIME,500);
    }

    @Override
    public void initView() {
        videoplay_videoview = (VideoView) findViewById(R.id.videoplay_videoview);
        /*顶部信息栏*/
        videoplay_name = (TextView) findViewById(R.id.videoplay_name);
        videoplay_systemtime = (TextView) findViewById(R.id.videoplay_systemtime);
        videoplay_battery = (ImageView) findViewById(R.id.videoplay_battery);
        videoplay_iv_volume = (ImageView) findViewById(R.id.videoplay_iv_volume);
        videoplay_sk_volume = (SeekBar) findViewById(R.id.videoplay_sk_volume);

        /*底部控制栏*/
        videoplay_position = (TextView) findViewById(R.id.videoplay_position);
        videoplay_duration = (TextView) findViewById(R.id.videoplay_duration);
        videoplay_sk_position = (SeekBar) findViewById(R.id.videoplay_sk_position);
        videoplay_exit = (ImageView) findViewById(R.id.videoplay_exit);
        videoplay_pre = (ImageView) findViewById(R.id.videoplay_pre);
        videoplay_play = (ImageView) findViewById(R.id.videoplay_play);
        videoplay_next = (ImageView) findViewById(R.id.videoplay_next);
        videoplay_full_screen = (ImageView) findViewById(R.id.videoplay_full_screen);
    }


    @Override
    public void pressClick(View v) {

    }

    private class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case Intent.ACTION_BATTERY_CHANGED:
                    int level = intent.getIntExtra("level",0);
                    if(level<10){
                        videoplay_battery.setImageResource(R.drawable.ic_battery_0);
                    }else if(level<20){
                        videoplay_battery.setImageResource(R.drawable.ic_battery_10);
                    }else if(level<30){
                        videoplay_battery.setImageResource(R.drawable.ic_battery_20);
                    }else if(level<50){
                        videoplay_battery.setImageResource(R.drawable.ic_battery_40);
                    }else if(level<70){
                        videoplay_battery.setImageResource(R.drawable.ic_battery_60);
                    }else if(level<90){
                        videoplay_battery.setImageResource(R.drawable.ic_battery_80);
                    }else{
                        videoplay_battery.setImageResource(R.drawable.ic_battery_100);
                    }
                    break;
            }
        }
    }

    private class MyOnPreparedListener implements MediaPlayer.OnPreparedListener {
        @Override
        /*预加载完成后回调*/
        public void onPrepared(MediaPlayer mp) {
            videoplay_videoview.start();
        }
    }
}
