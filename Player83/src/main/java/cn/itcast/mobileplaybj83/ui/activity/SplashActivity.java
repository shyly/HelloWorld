package cn.itcast.mobileplaybj83.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import cn.itcast.mobileplaybj83.MainActivity;
import cn.itcast.mobileplaybj83.R;

/**
 * Created by flykozhang on 2016/5/6.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void pressClick(View v) {
    }


}
