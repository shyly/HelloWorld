package cn.itcast.mobileplaybj83.db;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;

import cn.itcast.mobileplaybj83.adapter.VideoCursorAdapter;
import cn.itcast.mobileplaybj83.adapter.VideoFragmentAdapter;
import cn.itcast.mobileplaybj83.utils.CursorUtil;

/**
 * Created by flykozhang on 2016/5/6.
 */
public class VideoAsyncQueryHandler extends AsyncQueryHandler {
    public VideoAsyncQueryHandler(ContentResolver cr) {
        super(cr);
    }

    @Override
    protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
        super.onQueryComplete(token, cookie, cursor);
        VideoCursorAdapter adapter = (VideoCursorAdapter) cookie;
        adapter.swapCursor(cursor);
//        CursorUtil.pinotCursor(cursor);



    }
}
