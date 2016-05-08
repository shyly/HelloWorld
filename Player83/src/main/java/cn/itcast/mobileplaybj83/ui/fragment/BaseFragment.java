package cn.itcast.mobileplaybj83.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.itcast.mobileplaybj83.R;
import cn.itcast.mobileplaybj83.ui.UiInterface;

/**
 * Created by flykozhang on 2016/5/6.
 */
public abstract class BaseFragment extends Fragment implements UiInterface {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(),null);
        initView();
        initListener();
        initData();
        regCommonBtn();
        return view;
    }

    /*处理公共的控件初始化和监听*/
    protected void regCommonBtn() {
        View back = findViewById(R.id.back);
        if (back != null) {
            back.setOnClickListener(this);
        }
    }

    protected View findViewById(int res) {
        return view.findViewById(res);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                getFragmentManager().popBackStack(); //类似于acitivity的退栈，但是这个项目中没有用到。
                break;
            default:
                /*处理子类自己的点击事件*/
                pressClick(v);
                break;
        }
    }
}
