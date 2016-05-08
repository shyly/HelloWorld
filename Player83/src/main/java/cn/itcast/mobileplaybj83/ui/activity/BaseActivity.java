package cn.itcast.mobileplaybj83.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import cn.itcast.mobileplaybj83.R;
import cn.itcast.mobileplaybj83.ui.UiInterface;

/**
 * Created by flykozhang on 2016/5/6.
 */
public abstract class BaseActivity extends FragmentActivity implements UiInterface {
    public final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initListener();
        initData();
        regCommonBtn();
    }

    /*处理公共的控件初始化和监听*/
    protected void regCommonBtn(){
        View back = findViewById(R.id.back);
        if(back!=null){
            back.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            default:
                /*处理子类自己的点击事件*/
                pressClick(v);
                break;
        }
    }
}
