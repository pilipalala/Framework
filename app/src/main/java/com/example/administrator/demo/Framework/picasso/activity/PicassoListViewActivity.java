package com.example.administrator.demo.Framework.picasso.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.Framework.picasso.adapter.PicassoListViewAdapter;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PicassoListViewActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_picasso)
    ListView lvPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_list_view);
        ButterKnife.bind(this);
        tvTitle.setText("Picasso在ListView中使用");
        lvPicasso.setAdapter(new PicassoListViewAdapter(this));

    }
}
