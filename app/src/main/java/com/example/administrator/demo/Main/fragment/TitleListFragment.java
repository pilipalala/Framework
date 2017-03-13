package com.example.administrator.demo.Main.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.demo.R;
import com.example.administrator.demo.Framework.DataUtil;

/**
 * Created by Administrator on 2016/11/20.
 */
public class TitleListFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*给listView设置adapter显示列表*/
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, DataUtil.TITLES));
        /*设置ListView为单选模式*/
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        /*设置默认选中第一个*/
        getListView().setItemChecked(0, true);
        /*显示第一个详情*/
        show(0);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        show(position);
    }

    private void show(int position) {
        //创建DetailFragment
        DetailsFragment fragment = new DetailsFragment();
        //将对应的详情数据携带过去
        Bundle bundle = new Bundle();
        bundle.putString("detail", DataUtil.DETAILS[position]);
        fragment.setArguments(bundle);
        //将其替换到id为fl_detail的容器布局中
        getFragmentManager().beginTransaction().replace(R.id.fl_detail, fragment).commit();
    }
}
