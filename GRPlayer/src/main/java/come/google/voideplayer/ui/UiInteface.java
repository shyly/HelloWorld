package come.google.voideplayer.ui;

import android.view.View;

/**
 * Created by Administrator on 2016/5/6.
 * --------- 日期 ------- 维护人 ------------ 变更内容 --------
 * 2016/5/6		  Administrator			新增Person类
 * 2016/5/6		  Administrator			增加sex属性
 */

public interface UiInteface extends View.OnClickListener {

    void initView();
    void initData();
    int getLayoutId();
    void initListener();
    void pressClick(View v);
}
