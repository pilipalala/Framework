package com.example.administrator.demo.Framework.customview;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QuickIndexActivity extends BaseActivity {

    @Bind(R.id.lv_main)
    ListView lvMain;
    @Bind(R.id.tv_word)
    TextView tvWord;
    @Bind(R.id.iv_words)
    IndexView ivWords;
    @Bind(R.id.activity_quick_index)
    RelativeLayout activityQuickIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_index);
        ButterKnife.bind(this);
        ivWords.setOnIndexChangeListener(new IndexView.OnIndexChangeListener() {
            @Override
            public void onIndexChange(String word) {
                tvWord.setText(word);
            }
        });
    }
}
