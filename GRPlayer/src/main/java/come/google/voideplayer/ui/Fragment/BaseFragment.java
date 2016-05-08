package come.google.voideplayer.ui.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import come.google.voideplayer.R;
import come.google.voideplayer.ui.UiInteface;

/**
 * Created by Administrator on 2016/5/7.
 * --------- 日期 ------- 维护人 ------------ 变更内容 --------
 * 2016/5/7		  Administrator			新增Person类
 * 2016/5/7		  Administrator			增加sex属性
 */

public abstract class BaseFragment extends Fragment implements UiInteface {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(getLayoutId(), null);
        initView();
        initData();
        initListener();
        regConmmonBtn();
        return view;
    }

    /*处理公共的初始化和监听*/
    public void regConmmonBtn() {
        View back = findViewById(R.id.back);
        if(back!=null){
            back.setOnClickListener(this);
        }
    }

    protected  View findViewById(int res){

        return view.findViewById(res);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                getFragmentManager().popBackStack();//回退
                break;
            default:
                pressClick(v);
                break;
        }
    }
}
