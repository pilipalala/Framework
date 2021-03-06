package com.example.administrator.demo.Framework.customview.index;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    Handler handler = new Handler();
    private ArrayList<Person> persons;
    private IndexAdapter indexAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_index);
        ButterKnife.bind(this);
        indexAdapter = new IndexAdapter(this);
        initData();
        lvMain.setAdapter(indexAdapter);
        indexAdapter.setData(persons);

        ivWords.setOnIndexChangeListener(new IndexView.OnIndexChangeListener() {
            @Override
            public void onIndexChange(String word) {
                updateWord(word);
                updateListView(word);
            }
        });
    }

    private void updateListView(String word) {
        for (int i = 0; i <persons.size(); i++) {
            if (word.equals(PinYinUtils.getPinYin(persons.get(i).getPinyin().substring(0,1)))) {
                lvMain.setSelection(i);
                return;
            }
        }
    }

    private void updateWord(String word) {
    /*显示*/
        tvWord.setVisibility(View.VISIBLE);
        tvWord.setText(word);
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*也运行在主线程*/
                tvWord.setVisibility(View.GONE);
            }
        }, 1000);
    }

    /**
     * 初始化数据
     */
    private void initData() {

        persons = new ArrayList<>();
        persons.add(new Person("张晓飞"));
        persons.add(new Person("杨光福"));
        persons.add(new Person("胡继群"));
        persons.add(new Person("刘畅"));

        persons.add(new Person("钟泽兴"));
        persons.add(new Person("尹革新"));
        persons.add(new Person("安传鑫"));
        persons.add(new Person("张骞壬"));

        persons.add(new Person("温松"));
        persons.add(new Person("李凤秋"));
        persons.add(new Person("刘甫"));
        persons.add(new Person("娄全超"));
        persons.add(new Person("张猛"));

        persons.add(new Person("王英杰"));
        persons.add(new Person("李振南"));
        persons.add(new Person("孙仁政"));
        persons.add(new Person("唐春雷"));
        persons.add(new Person("牛鹏伟"));
        persons.add(new Person("姜宇航"));

        persons.add(new Person("刘挺"));
        persons.add(new Person("张洪瑞"));
        persons.add(new Person("张建忠"));
        persons.add(new Person("侯亚帅"));
        persons.add(new Person("刘帅"));

        persons.add(new Person("乔竞飞"));
        persons.add(new Person("徐雨健"));
        persons.add(new Person("吴亮"));
        persons.add(new Person("王兆霖"));

        persons.add(new Person("阿三"));
        persons.add(new Person("李博俊"));


        //排序
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person lhs, Person rhs) {
                return lhs.getPinyin().compareTo(rhs.getPinyin());
            }
        });

    }
}
