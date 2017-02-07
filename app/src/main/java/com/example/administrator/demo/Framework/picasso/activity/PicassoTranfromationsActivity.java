package com.example.administrator.demo.Framework.picasso.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.Framework.picasso.adapter.PicassoTranfromationsAdapter;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PicassoTranfromationsActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv_picasso_tranfromations)
    ListView lvPicassoTranfromations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_tranfromations);
        ButterKnife.bind(this);
        tvTitle.setText("图片转换");
        lvPicassoTranfromations.setAdapter(new PicassoTranfromationsAdapter(this));

    }
}
