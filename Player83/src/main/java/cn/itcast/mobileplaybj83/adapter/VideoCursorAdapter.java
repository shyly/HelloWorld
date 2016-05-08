package cn.itcast.mobileplaybj83.adapter;

import android.content.Context;
import android.database.Cursor;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import cn.itcast.mobileplaybj83.R;
import cn.itcast.mobileplaybj83.bean.VideoItem;
import cn.itcast.mobileplaybj83.utils.StringUtil;

/**
 * Created by flykozhang on 2016/5/6.
 */
public class VideoCursorAdapter extends CursorAdapter {
    public VideoCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = View.inflate(context, R.layout.video_item,null);
        ViewHoder hoder = new ViewHoder(view);
        view.setTag(hoder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHoder hoder = (ViewHoder) view.getTag();
        VideoItem item = VideoItem.instanceFromCursor(cursor);
        hoder.main_video_name.setText(item.getTitle());
        hoder.main_video_duration.setText(StringUtil.fromatDuration(item.getDuration()));
        hoder.main_video_size.setText(Formatter.formatFileSize(context,item.getSize()));
    }

    class ViewHoder {
        private TextView main_video_name,main_video_duration,main_video_size;
        public ViewHoder(View root) {
            main_video_name = (TextView) root.findViewById(R.id.main_video_name);
            main_video_duration = (TextView) root.findViewById(R.id.main_video_duration);
            main_video_size = (TextView) root.findViewById(R.id.main_video_size);
        }
    }
}
