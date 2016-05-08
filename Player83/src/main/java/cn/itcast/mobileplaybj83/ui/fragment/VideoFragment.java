package cn.itcast.mobileplaybj83.ui.fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore.Video.Media;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import cn.itcast.mobileplaybj83.R;
import cn.itcast.mobileplaybj83.adapter.VideoCursorAdapter;
import cn.itcast.mobileplaybj83.bean.VideoItem;
import cn.itcast.mobileplaybj83.db.VideoAsyncQueryHandler;
import cn.itcast.mobileplaybj83.ui.activity.VideoPlayActivity;

/**
 * Created by flykozhang on 2016/5/6.
 */
public class VideoFragment extends BaseFragment implements AdapterView.OnItemClickListener{

    private ListView listview;
    private VideoCursorAdapter adapter;

    @Override
    public void initData() {
        ContentResolver contentResolver = getActivity().getContentResolver();
        VideoAsyncQueryHandler asyncQueryHandler = new VideoAsyncQueryHandler(contentResolver);
        asyncQueryHandler.startQuery(0, adapter, Media.EXTERNAL_CONTENT_URI, new String[]{Media._ID, Media.DATA,
                Media.DURATION, Media.SIZE, Media.TITLE}, null, null, null);
    }

    @Override
    public void initListener() {
        listview.setOnItemClickListener(this);
        adapter = new VideoCursorAdapter(getActivity(), null);
        listview.setAdapter(adapter);
    }

    @Override
    public void initView() {
        listview = (ListView) findViewById(R.id.listview);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    public void pressClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cursor cursor = (Cursor) parent.getItemAtPosition(position);
        VideoItem item = VideoItem.instanceFromCursor(cursor);
        Intent intent = new Intent(getActivity(),VideoPlayActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);
    }
}
