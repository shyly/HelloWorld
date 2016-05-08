package come.google.voideplayer.ui.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import come.google.voideplayer.MainActivity;
import come.google.voideplayer.R;

/**
 * Created by Administrator on 2016/5/6.
 * --------- 日期 ------- 维护人 ------------ 变更内容 --------
 * 2016/5/6		  Administrator			新增Person类
 * 2016/5/6		  Administrator			增加sex属性
 */

public class SplashActivity extends BaseActivity {
    Handler handler = new Handler();

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void pressClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
