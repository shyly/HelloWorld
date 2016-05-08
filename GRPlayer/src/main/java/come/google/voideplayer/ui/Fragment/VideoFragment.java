package come.google.voideplayer.ui.Fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import come.google.voideplayer.R;
import come.google.voideplayer.adapter.VideoAdapter;

/**
 * Created by Administrator on 2016/5/7.
 * --------- 日期 ------- 维护人 ------------ 变更内容 --------
 * 2016/5/7		  Administrator			新增Person类
 * 2016/5/7		  Administrator			增加sex属性
 */

public class VideoFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private ListView listview;
    private VideoAdapter adapter;

    @Override
    public void initView() {
        listview = (ListView) findViewById(R.id.listview);

        listview.setOnItemClickListener(this);

        adapter = new VideoAdapter(getActivity(),null);
        listview.setAdapter(adapter);
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.main_video;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void pressClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
