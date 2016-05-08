package come.google.voideplayer.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;

/**
 * Created by Administrator on 2016/5/7.
 * --------- 日期 ------- 维护人 ------------ 变更内容 --------
 * 2016/5/7		  Administrator			新增Person类
 * 2016/5/7		  Administrator			增加sex属性
 */

public class VideoAdapter extends CursorAdapter {


    public VideoAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
