package come.google.voideplayer.ui.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import come.google.voideplayer.R;
import come.google.voideplayer.ui.UiInteface;

/**
 * Created by Administrator on 2016/5/6.
 * --------- 日期 ------- 维护人 ------------ 变更内容 --------
 * 2016/5/6		  Administrator			新增Person类
 * 2016/5/6		  Administrator			增加sex属性
 */

public abstract class BaseActivity extends FragmentActivity implements UiInteface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initListener();
        initData();
        regConmmonBtn();
    }

    /*处理公共的初始化和监听*/
    public void regConmmonBtn() {
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
                pressClick(v);
                break;
        }
    }
}
